package com.smikevon.algorithm.basicSort;

import java.util.LinkedList;
import java.util.List;

public class BitMapSort {

	public static int[] array = {4,29,34,2,56,43,22,18,41,67,99,65,85,32,44,3,76};

	public static void main(String[] args) {
		Integer[] info = sort(array, 17);
		for(int tmp : info){
			System.out.print(tmp + " ");
		}
	}

	public static Integer[] sort(int[] array,int n){
		int max = 0;
		for(int i=0;i<array.length;i++){
			if(array[i]>max){
				max = array[i];
			}
		}

		byte[] sortArray = new byte[max+1];

		for(int i=0;i<array.length;i++){
			sortArray[array[i]]=1;
		}

		List<Integer> list = new LinkedList<Integer>();

		for(int i=0;i<sortArray.length;i++){
			if(sortArray[i] == 1){
				list.add(i);
			}
		}

		return list.toArray(new Integer[0]);
	}

}
