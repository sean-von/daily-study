package com.smikevon.basic.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TestGetMaxSubArray {

	public static void main(String[] args) {

		int[] array = {1,2,-4,3,5,-4,7,8,2,-1,6,-5,-200,3,47,-2};

		System.out.println(findMaxValue(array));

		//寻找最大子串
		int [] subArray = findMaxSubArray(array);
		for(int tmp : subArray){
			System.out.print(tmp+ " ");
		}

		System.out.println();
		//寻找最长子串
		int[] lenArray = findMaxLengthArray(array);
		for(int tmp : lenArray){
			System.out.print(tmp+ " ");
		}

		System.out.println();
		System.out.print("计算最长公共子序列:");
		/*String str1 = "wewoxcaibwebeisdf jingerttiansfgdanmen466";
		String str2 = "34556wo3234ai234bei5466jing123tianweran456men";*/


		String str1 = "abcdefhg";
		String str2 = "bcdefhig";

		//System.out.println(findLongestCommonString(str1.toCharArray(),str2.toCharArray(),0,0));

		System.out.println(findLongestCommonStringDynamic(str1.toCharArray(),str2.toCharArray()));

		findLongestSubString(str1.toCharArray(),str2.toCharArray());

	}



	/**
	 * @Description:找到最大子串和
	 * @param array
	 * @return
	 * @returType:int
	 */
	public static int findMaxValue(int[] array){
		int max = 0;
		int sum = 0;
		for(int i=0;i<array.length;i++){
			sum = sum + array[i];
			if(sum > max){
				max = sum;
			}else if(sum<0){
				sum = 0;
			}
		}
		return max;
	}

	/**
	 * @Description:找到一个字符串的最大子串
	 * @param array
	 * @return
	 * @returType:int[]
	 */
	public static int[] findMaxSubArray(int[] array){
		int max = 0;
		int sum = 0;
		int start = 0;
		int end = 0;
		int tmpStart = 0;
		for(int i=0;i<array.length;i++){
			sum = sum + array[i];
			if(sum > max){
				max = sum;
				start = tmpStart;
				end = i;
			}else if(sum<0){
				sum = 0;
				tmpStart = i;
			}
		}
		return Arrays.copyOfRange(array, start+1, end+1);//截取不包括自己
	}

	/**
	 * @Description:求最长子串
	 * @param array
	 * @return
	 * @returType:int[]
	 */
	public static int[] findMaxLengthArray(int[] array){
		//key 放置数组的元素，value 第一个元素存放起始位置，第二个放置结束位置，第三个元素存放距离
		Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
		for(int i=0;i<array.length;i++){
			if(map.get(array[i])==null){
				Integer[] ints = new Integer[3];
				ints[0]=i;//初始位置
				ints[1]=i;//结束位置
				ints[2]=0;//初始长度
				map.put(array[i], ints);
			}else{
				map.get(array[i])[1]=i;
				map.get(array[i])[2]=i-map.get(array[i])[0];
			}
		}
		Iterator<Entry<Integer, Integer[]>> iterator = map.entrySet().iterator();
		int max = 0;
		int start = 0;
		int end = 0;
		int key = 0;
		while(iterator.hasNext()){
			Entry<Integer, Integer[]> entry = iterator.next();
			if(entry.getValue()[2]>max){
				max = entry.getValue()[2];
				start = entry.getValue()[0];
				end = entry.getValue()[1];
				key = entry.getKey();
			}
		}
		System.out.println("最大长度的数字是："+ key);
		System.out.println("最大长度为:"+max);
		return Arrays.copyOfRange(array, start+1, end+1);//截取不包括自己
	}

	/**
	 * @Description:递归方法求最大公共子序列
	 * @param str1
	 * @param str2
	 * @param i
	 * @param j
	 * @return
	 * @returType:int
	 */
	public static int findLongestCommonString(char[] str1,char[] str2,int i,int j){
		if(i>str1.length-1 || j>str2.length-1){
			return 0;
		}else if(str1[i]==str2[j]){

			return 1+findLongestCommonString(str1, str2, i+1, j+1);
		}else{
			int value1 = findLongestCommonString(str1, str2, i+1, j);
			int value2 = findLongestCommonString(str1, str2, i, j+1);
			return value1 > value2 ? value1 : value2;
		}
	}

	/**
	 * @Description:动态规划方法求最大公共子序列
	 * @param str1
	 * @param str2
	 * @return
	 * @returType:int
	 */
	public static int findLongestCommonStringDynamic(char[] str1,char[] str2){
		int[][] array = new int[str1.length+1][str2.length+1];
		int[][] flag = new int[str1.length+1][str2.length+1];
		for(int i=0;i<str1.length+1;i++){
			for(int j=0;j<str2.length+1;j++){
				if(i==0 || j==0){//第一行和第一列单独处理,为了求公共子序列方便
					array[i][j] = 0;
					flag[i][j] = 0;
				}else if(str1[i-1] == str2[j-1]){//这里比较的是i-1和j-1
					array[i][j]=1+array[i-1][j-1];
					flag[i][j]=1;
				}else{
					array[i][j]=array[i-1][j]>array[i][j-1]?array[i-1][j]:array[i][j-1];
					flag[i][j]=array[i-1][j]>array[i][j-1]?2:3;
				}
			}
		}

		int max = 0;
		//求最长公共子序列的长度
		for(int i=0;i<str1.length+1;i++){
			for(int j=0;j<str2.length+1;j++){
				System.out.print(array[i][j]+" ");
				if(array[i][j]>max){
					max = array[i][j];
				}
			}
			System.out.println();
		}


		StringBuffer sb = new StringBuffer();

		int i=str1.length;
		int j=str2.length;

		while(i>0 && j>0){
			if(flag[i][j] == 1){
				sb.append(str1[i-1]);
				i--;
				j--;
			}else if(flag[i][j]==2){
				i--;
			}else if(flag[i][j]==3){
				j--;
			}

		}

		System.out.println(sb.reverse().toString());

		return max;
	}

	/**
	 * @Description:查找最大公共子串
	 * @param str1
	 * @param str2
	 * @return
	 * @returType:String
	 */
	public static String findLongestSubString(char[] str1,char[] str2){
		//第一行第一列全为0
		int[][] array = new int[str1.length+1][str2.length+1];
		for(int i=0;i<str1.length+1;i++){
			for(int j=0;j<str2.length+1;j++){
				if(i==0 || j==0){
					array[i][j] = 0;
				}else if(str1[i-1] == str2[j-1]){
					array[i][j] = 1 + array[i-1][j-1];
				}else{
					array[i][j]=0;
				}
			}
		}

		int max = 0;
		int tmpi = 0;
		for(int i=0;i<str1.length+1;i++){
			for(int j=0;j<str2.length+1;j++){
				if(array[i][j]>max){
					max = array[i][j];
					tmpi = i-1;
				}
			}
		}

		StringBuffer sb = new StringBuffer();
		for(int i=tmpi;tmpi-i<max;i--){
			sb.append(str1[i]);
		}

		System.out.println("最大字串长度是:"+max);
		System.out.println("最长字串是:"+sb.reverse().toString());

		return "";
	}



}
