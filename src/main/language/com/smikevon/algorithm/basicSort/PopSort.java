package com.smikevon.algorithm.basicSort;

/**
 * @description: 简单排序之冒泡排序算法：从后向前逐次选择未排序的最小的数
 * @author     : fengxiao
 * @date       : 2014年8月22日 上午11:39:29
 */
public class PopSort {

	public static int[] array = {4,29,34,2,56,43,22,18,41,67,99,65,85,32,44,3,76};

	public static void main(String[] args) {
		sort(array, 17);
		for(int tmp : array){
			System.out.print(tmp + " ");
		}
	}

	public static void sort(int[] array,int n){
		for(int i=0;i<n;i++){
			//找出第i小的数
			for(int j=n-1;j>i;j--){
				if(array[j]<array[j-1]){
					int tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp;
				}
			}
		}
	}

}
