package com.smikevon.algorithm.basicSort;


/**
 * @description: 简单排序之选择排序：对冒泡排序的一个改进，不需要每次找出最小未排序数时就进行多次交换，而是进行记录，直接与未排序的第一个位置进行交换
 * @author     : fengxiao
 * @date       : 2014年8月22日 上午11:43:45
 */
public class SelectionSort {

	public static int[] array = {4,29,34,2,56,43,22,18,41,67,99,65,85,32,44,3,76};

	public static void main(String[] args) {
		sort(array, 17);
		for(int tmp : array){
			System.out.print(tmp + " ");
		}
	}

	public static void sort(int[] array, int n){
		for(int i=0;i<n;i++){
			int flag = n-1;
			//标记未排序序列中的最小值下标
			for(int j=n-1;j>i;j--){
				if(array[flag]>array[j-1]){
					flag = j-1;
				}
			}
			int tmp = array[flag];
			array[flag] = array[i];
			array[i] = tmp;
		}
	}

}
