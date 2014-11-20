package com.smikevon.algorithm.basicSort;

/**
 * @description: 排序算法之快速排序
 * @author     : fengxiao
 * @date       : 2014年8月25日 下午3:18:14
 */
public class QuickSort {

	public static int[] array = {4,29,34,2,56,43,22,18,41,67,99,65,85,32,44,3,76};

	public static void main(String[] args) {
		sort(array, 0,16);
		System.out.print("最终：");
		for(int tmp : array){
			System.out.print(tmp + " ");
		}
	}

	public static void sort(int[] array,int low,int high){
		if(low >= high){
			return;
		}
		//选定分区左边第一个数为划分分区的点
		int i = low;
		int j = high;


		while(j>i){

			while(array[j]>=array[low] && j>i){
				j--;
			}

			while(array[i]<=array[low] && i<j){
				i++;
			}
			if(j>i){
				int tmp = array[j];
				array[j] = array[i];
				array[i] = tmp;
			}

			for(int tmp : array){
				System.out.print(tmp + " ");
			}
			System.out.println();
		}


		int tmp = array[i] ;
		array[i] = array[low];
		array[low] = tmp;

		sort(array, low, i-1);
		sort(array, i+1, high);

		System.out.print("排序完：");
		for(int t : array){
			System.out.print(t + " ");
		}
		System.out.println();
	}
}
