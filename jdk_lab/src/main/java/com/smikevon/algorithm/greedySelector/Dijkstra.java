package com.smikevon.algorithm.greedySelector;

/**
 * @description: Dijkstra算法，贪心算法的一种
 * 				 用以解决单源最短路径问题，算法时间复杂度O（n2），用以计算从源点到各个点的最短距离
 *
 * 				 先构造邻接矩阵，然后计算单源最短路径
 *
 *
 * @author     : fengxiao
 * @date       : 2014年8月12日 上午10:30:16
 */
public class Dijkstra {

	private static final int MAX = Integer.MAX_VALUE;

	//临接矩阵,c[0][0] 是源点
	private static int[][] c = {
			{ 0,   10,  MAX, 30,  100 },
			{ MAX, 0,   50,  MAX, MAX },
			{ MAX, MAX, 0,   MAX, 10  },
			{ MAX, MAX, 20,  0,   60  },
			{ MAX, MAX, MAX, MAX, 0   }
	};

	public static void main(String[] args) {
		int[] dist = new int[5];//最短路径长度
		int[] pre = new int[5];//最短路径对应点的上一点
		dijkstra(c, dist, 5, pre);

		System.out.print("源点到各点的最短距离：");
		for(int tmp : dist){
			System.out.print(tmp+" ");
		}

		System.out.println();

		for(int i=0;i<5;i++){
			printPath(pre, i,i);
		}

	}

	/**
	 * @Description:dijkstra 算法计算源点到各个点的最短路径
	 * @param c
	 * @param dist
	 * @param n
	 * @returType:void
	 */
	public static void dijkstra(int[][]c, int[] dist, int n, int[] pre){
		boolean[] status = new boolean[5];

		//初始化源点到各点距离,统一初始化为MAX，后面循环中再按邻接矩阵处理
		for(int i=0;i<n;i++){
			dist[i] = i==0?0:MAX;
		}

		//初始化，源点本身就已经在结果集合中，故初始化为true
		for(int i =0;i<status.length;i++){
			status[i] = i==0?true:false;
		}

		int v = 0;//从源点开始

		//一次选出一个结果集点，因此要走n遍
		for(int j=0;j<n;j++){

			//重新计算当前各点到已有最短路径的距离
			for(int k=0;k<n;k++){
				//未被标记为最短路径，并且此点到已有最短路径的和值小于之前计算的最短路径
				if(!status[k] && c[v][k]!=MAX && (dist[v]+c[v][k]<dist[k])){
					dist[k] = dist[v]+c[v][k];
				}
			}

			//寻找上一步计算出来的当步最短路径中的min最短路径
			int tmpMin = MAX;
			int tmpPos = -1;
			for(int k=0;k<n;k++ ){
				if(!status[k] && dist[k]<tmpMin){
					tmpPos = k;
					tmpMin = dist[k];
				}
			}

			//整理结果，重新设定最新的结果集，加入新的点
			if(tmpPos != -1){
				dist[tmpPos] = tmpMin;
				pre[tmpPos] = v;
				status[tmpPos] = true;
				v= tmpPos;
			}

		}
	}

	/**
	 * @Description:打印最短路径经过的点
	 * @param pre
	 * @param pos 递归用到的点
	 * @param finalPos 最终的点
	 * @returType:void
	 */
	public static void printPath(int[] pre,int pos,int finalPos){
		if(pos == 0){
			if(finalPos!=0){
				System.out.print(finalPos+"的最短路径：0 ");
			}
			return;
		}
		printPath(pre, pre[pos],finalPos);
		System.out.print(pos + " ");
		if(pos == finalPos){
			System.out.println();
		}
	}



}
