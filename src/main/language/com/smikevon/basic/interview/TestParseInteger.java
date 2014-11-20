package com.smikevon.basic.interview;

import java.util.Arrays;

public class TestParseInteger {

	public static void main(String[] args) throws Exception {
		System.out.println(getInt("345"));

		Integer.parseInt("345");

		int[] array = {1,4,10,15,31,60,40,35,30,20,15,7};
		System.out.println(getMax(array));

	}

	/**
	 * @Description:将一个数字字符串转换成数字，不使用parseInt
	 * @param str
	 * @return
	 * @returType:int
	 */
	public static int getInt(String str){
		char[] numbers = str.toCharArray();
		int value = 0;
		for(int i=0;i<numbers.length;i++){
			int tmp = numbers[i];//ascii 码的'1'对应的十进制是49，因此在计算的时候要减48
			value += (tmp-'0')*Math.pow(10, numbers.length-1-i);
		}
		return value;
	}

	/**
	 * @Description:计算一个单调递增后，又单调递减数列的最大值
	 * @param array;
	 * @return
	 * @throws Exception
	 * @returType:int
	 */
	public static int getMax(int[] array) throws Exception{
		if(array.length <=3){
			int max = 0;
			for(int tmp : array){
				if(tmp>max){
					max = tmp;
				}
			}
			return max;
		}
		int middle = array.length >> 1;
		if(array[middle-1] < array[middle] && array[middle]<array[middle+1]){
			return getMax(Arrays.copyOfRange(array, middle, array.length));
		}else if(array[middle-1] > array[middle] && array[middle]>array[middle+1]){
			return getMax(Arrays.copyOfRange(array, 0, middle));
		}else if(array[middle-1] < array[middle] && array[middle] > array[middle+1]){
			return array[middle];
		}else{
			throw new Exception("数列不符合输入要求");
		}
	}

}
