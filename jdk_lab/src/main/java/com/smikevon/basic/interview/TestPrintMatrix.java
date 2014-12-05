package com.smikevon.basic.interview;

/**
 * @description: 螺旋矩阵的构造与读出
 * @author     : fengxiao
 * @date       : 2014年10月11日 上午10:23:50
 */
public class TestPrintMatrix {

	public static int[][] matrix = {
		{1 ,2 ,3 ,4 ,5 ,6 },
		{18,19,20,21,22,7 },
		{17,28,29,30,23,8 },
		{16,27,26,25,24,9 },
		{15,14,13,12,11,10 },
	};

	public static void main(String[] args) {
		printMatrix(matrix, 0, 4, 0, 5);

		int[][] newMatrix = new int[5][6];

		generateMatrix(newMatrix, 0, 4, 0, 5, 0);

		for(int i=0;i<5;i++){
			for(int j=0;j<6;j++){
				System.out.print(newMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	/**
	 * @Description:将一螺旋矩阵读出来
	 * @param matrix
	 * @param startM
	 * @param endM
	 * @param startN
	 * @param endN
	 * @returType:void
	 */
	public static void printMatrix(int[][] matrix,int startM,int endM,int startN, int endN){
		if(endM - startM != 0 && endN - startN!= 0){
			for(int i=startN;i<endN;i++){
				System.out.print(matrix[startM][i] + " ");
			}
			for(int i=startM;i<endM;i++){
				System.out.print(matrix[i][endN]+" ");
			}
			for(int i=endN;i>startN;i--){
				System.out.print(matrix[endM][i]+" ");
			}
			for(int i=endM;i>startM;i--){
				System.out.print(matrix[i][startN]+" ");
			}
			printMatrix(matrix, startM+1, endM-1, startN+1, endN-1);
		}else if(endM - startM == 0){
			for(int i=startN;i<endN;i++){
				System.out.print(matrix[startM][i]+" ");
			}
		}else{
			for(int i=startM;i<endM;i++){
				System.out.print(matrix[i][startN]+" ");
			}
		}
	}

	/**
	 * @Description:给定一个行和列，生成螺旋矩阵
	 * @param matrix
	 * @param startM
	 * @param endM
	 * @param startN
	 * @param endN
	 * @param count
	 * @returType:void
	 */
	public static void generateMatrix(int[][] matrix,int startM,int endM,int startN, int endN,int count){
		if(endM - startM != 0 && endN - startN!= 0){
			for(int i=startN;i<endN;i++){
				matrix[startM][i] = ++count;
			}
			for(int i=startM;i<endM;i++){
				matrix[i][endN] = ++count;
			}
			for(int i=endN;i>startN;i--){
				matrix[endM][i] = ++count;
			}
			for(int i=endM;i>startM;i--){
				matrix[i][startN] = ++count;
			}
			generateMatrix(matrix, startM+1, endM-1, startN+1, endN-1,count);
		}else if(endM - startM == 0){
			for(int i=startN;i<endN;i++){
				matrix[startM][i] = ++count;
			}
		}else{
			for(int i=startM;i<endM;i++){
				matrix[i][startN] = ++count;
			}
		}
	}



}
