package com.smikevon.algorithm.greedySelector;

/**
 * @description: 计算最小生成树的Prime算法，计算无向带权图的最小生成树
 * @author     : fengxiao
 * @date       : 2014年8月13日 下午3:03:43
 */
public class Prime {

	private static final int MAX = Integer.MAX_VALUE;

	/**
	 * 将图转换为邻接矩阵，一个点自己到自己为0，到不了的点设置为一个超大值，谁是c[0][0]其实是随意选取的，毕竟是无向带权图
	 */
	public static int[][] c = {
		{ 0,   6,   1,   5,   MAX, MAX },
		{ 6,   0,   5,   MAX, 3,   MAX },
		{ 1,   5,   0,   5,   6,   4   },
		{ 5,   MAX, 5,   0,   MAX, 2   },
		{ MAX, 3,   6,   MAX, 0,   6   },
		{ MAX, MAX, 4,   2,   6,   0   }
	};

	public static void main(String[] args){
		//状态数组，true则表明点已经在最小生成树里，false则表示不在最小生成树里
		boolean[] status = new boolean[6];

		//记录生成树路径，例如下标是2，start[2]=3,表示从点3到点2
		int[] start = new int[6];

		prime(c, status, 6, start);

		printTree(c,status, start, 6);
	}

	/**
	 * @Description:prime 算法计算最小生成树
	 * @param c	将图转换为邻接矩阵
	 * @param status 对点进行标记，已经成为最小生成树一部分的标记位true
	 * @param n 树的规模
	 * @param start 用以记录是从哪个点到目标点的，start记录的是已知最小生成树的点
	 * @returType:void
	 */
	public static void prime(int[][] c,boolean[] status,int n,int[] start){

		//设置到已知最小生成树集合的权值数组，默认都为MAX
		int[] weight = new int[n];
		for(int i=0;i<n;i++){
			weight[i] = MAX;
		}

		//选定第一个点为最小生成树中的一个点
		status[0] = true;
		//到自己的权重为0
		weight[0] = 0;

		//设置当前最新加入到最小生成图的点，初始时第0个点加入
		int v = 0;

		//每次循环找出一条边，最多n-1此循环
		for(int j=0;j<n-1;j++){

			//找出当前各个未加入最小生成树的点到已经加入最小生成树点的最小权值
			for(int k=0;k<n;k++){
				if(!status[k] && c[v][k]!=MAX && c[v][k]<weight[k]){
					weight[k] = c[v][k];

					/**
					 * 记录是从点v到点k的权值
					 *
					 * 这里很关键，要记录是从哪个点到当前点的权值
					 */
					start[k]=v;
				}
			}

			//打印一下没一次的变化过程
			for(int tmp : weight){
				System.out.print(tmp + " ");
			}

			//假定最小权的点
			int minPos = 0;
			int minWeight = MAX;
			//循环找出本轮最小的权值
			for(int k=0;k<n;k++){
				if(!status[k] && weight[k]<minWeight){
					minWeight = weight[k];
					minPos = k;
				}
			}

			//设定当前找出的最新加入最小生成树的边，不一定是点v到点minPos，可能是上一轮的最小权值
			status[minPos] = true;
			v=minPos;
		}

	}

	/**
	 * @Description:打印最小生成树
	 * @param c
	 * @param path
	 * @param n
	 * @returType:void
	 */
	public static void printTree(int[][] c,boolean[] status, int[] start,int n){

		//忽略到点0到点0
		for(int i=1;i<n;i++){
			System.out.println("边：点"+start[i]+"到点"+i+",权值为:"+c[start[i]][i]);
		}
	}

}
