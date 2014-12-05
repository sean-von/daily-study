package com.smikevon.basic.interview;

public class TestCheckPower {

	public static void main(String[] args) {
		System.out.println(check(16));
	}

	/**
	 * @Description:察看一个整数是不是2的幂
	 * @param power
	 * @return
	 * @returType:boolean
	 */
	public static boolean check(int power){
		if(power <= 1){
			return false;
		}
		if((power & (power-1))!=0){
			return false;
		}
		return true;
	}

}
