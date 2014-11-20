package com.smikevon.algorithm.greedySelector;

/**
 * 活动安排问题
 *
 * 贪心算法总能求得活动安排问题的整体最优解，即它所确定的最终相容活动集合A的规模最大
 *
 * 时间复杂度为O（nlogn）主要都花费在了非减排序上了
 *
 * @author fengxiao
 *
 */
public class ActivityArrangement {

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args){
		//先把活动按结束时间进行非减排序
		int[] s = {1,3,0,5,3,5,6,8,8,2,12};
		int[] f = {4,5,6,7,8,9,10,11,12,13,14};
		boolean[] A = new boolean[11];
		//传址调用
		greedySelector(11, s, f, A);

		for(boolean tmp : A){
			System.out.print(tmp+" ");
		}
		System.out.println("==============================");
		boolean abc = true;
		//传值调用
		testBoolean(abc);
		System.out.println(abc);
	}

	public static void greedySelector(int n,int[] s,int[] f,boolean A[]){
		int j = 1;
		A[j] = true;
		for(int i=2;i<n;i++){
			if(s[i]>f[j]){
				A[i]=true;
				j = i;
			}else{
				A[i]=false;
			}
		}
	}

	public static void testBoolean(boolean abc){
		abc = false;
	}


}
