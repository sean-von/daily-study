package com.smikevon.algorithm.greedySelector;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @description: 解决最小生成树问题的Kruskal算法，时间复杂度是 O（eloge） e是路径的个数
 * @author     : fengxiao
 * @date       : 2014年8月14日 上午11:05:54
 */
public class Kruskal {

	public static void main(String[] args) {

		//初始化无向连通带权图的各个边
		List<Edge> list = new LinkedList<Edge>(){
			private static final long serialVersionUID = -1763183685697914738L;
			{
				add(new Edge(1, 2, 6));
				add(new Edge(1, 3, 1));
				add(new Edge(1, 4, 5));
				add(new Edge(2, 3, 5));
				add(new Edge(2, 5, 3));
				add(new Edge(3, 4, 5));
				add(new Edge(3, 5, 6));
				add(new Edge(3, 6, 4));
				add(new Edge(4, 6, 2));
				add(new Edge(5, 6, 6));
			}
		};

		//初始化各个点的值
		int[] points = new int[6];
		points[0] = 1;
		points[1] = 2;
		points[2] = 3;
		points[3] = 4;
		points[4] = 5;
		points[5] = 6;

		/**
		 * 实质上是一种归并排序，排序的元素必须实现Comparable 接口，时间复杂度是O（nlogn）
		 */
		Collections.sort(list);

		//设置连通分区标志map
		Map<Integer, List<Integer>> edgeMap = new HashMap<Integer, List<Integer>>();

		//每个点分数不同的连通分区
		for(int i=0;i<6;i++){
			List<Integer> tmplist = new LinkedList<Integer>();
			tmplist.add(points[i]);
			edgeMap.put(i, tmplist);
		}

		/**
		 * 之需要循环一次就可以选出所有的路径，非减序总能找到最合适的
		 */
		for (int i = 0; i < list.size(); i++) {
			if(!dealPartition(edgeMap, list.get(i).getPointA(), list.get(i).getPointB())){
				list.remove(i);
				i--;
			}
		}

		//打印出选出来的路径
		for(Edge edge : list){
			System.out.println(edge.toString());
		}

	}

	/**
	 * @Description:处理连通分区，如果点A和点B在同一个连通分区，返回false，如果不在同一个连通分区，返回true，并且合并两个连通分区
	 * @param edgeMap
	 * @param pointA
	 * @param pointB
	 * @returType:void
	 */
	public static boolean dealPartition(Map<Integer, List<Integer>> edgeMap,int pointA,int pointB){

		//遍历各连通分区查找两个顶点各属于哪个连通分区，属于分治查找时间复杂度logN ？h
		Iterator<Integer> iterator = edgeMap.keySet().iterator();
		int keyA = -1;
		int keyB = -1;
		while (iterator.hasNext()) {
			int tmpKey = iterator.next();
			List<Integer> tmpList = edgeMap.get(tmpKey);

			if(tmpList.indexOf(Integer.valueOf(pointA))>-1){
				keyA = tmpKey;
			}

			if(tmpList.indexOf(Integer.valueOf(pointB))>-1){
				keyB = tmpKey;
			}
		}

		//不在一个连通分区，合并连通分区,删除被合并的连通分区
		if(keyA!=-1 && keyB != -1 && keyA != keyB){
			List<Integer> tmpList = edgeMap.get(keyA);
			tmpList.addAll(edgeMap.get(keyB));
			edgeMap.put(keyA, tmpList);
			edgeMap.remove(keyB);
			return true;
		}

		//在同一个连通分区，则此路径不符合筛选条件，返回false
		return false;
	}

}

/**
 * 边的抽象类，pointA，pointB代表连接边的两个顶点
 */
class Edge implements Comparable<Edge>{

	int pointA ;
	int pointB ;
	int weight ;

	public Edge(int pointA, int pointB, int weight) {
		this.pointA = pointA;
		this.pointB = pointB;
		this.weight = weight;
	}
	public int getPointA() {
		return pointA;
	}
	public int getPointB() {
		return pointB;
	}
	public int getWeight() {
		return weight;
	}
	/**
	 * 重写类的比较方法，便于进行排序
	 */
	public int compareTo(Edge o) {
		return getWeight()>o.getWeight()?1:getWeight()==o.getWeight()?0:-1;
	}

	public String toString() {
		return "Edge [pointA=" + pointA + ", pointB=" + pointB + ", weight="
				+ weight + "]";
	}
}