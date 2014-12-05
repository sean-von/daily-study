package com.smikevon.jvm;


public class TestQuickSort {


	public static void main(String[] args) {

		int[] array = {3,5,16,2,4,13,87,34,56,45,23,89,53,44};

		QuickSort(array, 0, 13);

		for(int tmp : array){
			System.out.print(tmp+" ");
		}

	}

	public static void QuickSort(int[] array,int low,int high){

		if(low>=high){
			return;
		}
		int i = low;
		int j = high;

		//选定array[low]为分割点
		while(i<j){

			while(array[j]>=array[low] && j>i){
				j--;
			}

			while(array[i]<=array[low] && j>i){
				i++;
			}

			int tmp = array[j];
			array[j] = array[i];
			array[i] = tmp;
		}

		//结束后将array[low]和array[i]进行替换
		int tmp = array[low];
		array[low] = array[i];
		array[i] = tmp;

		QuickSort(array, low, i-1);
		QuickSort(array, i+1, high);
	}

}
