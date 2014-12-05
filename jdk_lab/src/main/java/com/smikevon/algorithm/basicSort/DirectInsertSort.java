package com.smikevon.algorithm.basicSort;


/**
 * @description: 简单排序之直接插入排序
 * @author     : fengxiao
 * @date       : 2014年8月22日 上午11:05:42
 */
public class DirectInsertSort {

	public static int[] array = {4,29,34,2,56,43,22,18,41,67,99,65,85,32,44,3,76};

	public static void main(String[] args) {
		sort(array, 17);
		for(int tmp : array){
			System.out.print(tmp + " ");
		}
	}

	public static void sort(int[] array,int n){
		for(int i=1;i<n;i++){

			//将未排序的第一个数与已排序的序列进行比较，如果小就前移
			for(int j = i;j>0;j--){
				if(array[j]<array[j-1]){
					int tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp;
				}else{
					break;
				}
			}
		}
	}
}
