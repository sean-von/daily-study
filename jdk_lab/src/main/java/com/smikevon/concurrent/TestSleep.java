package com.smikevon.concurrent;

public class TestSleep {

	public static void main(String[] args) throws InterruptedException {
		String[] strs = {
			"我是",
			"中华人民共和国",
			"北京的",
			"一名普通公民"
		};

		for(int i=0;i<strs.length;i++){
			Thread.sleep(4000);
			System.out.println(strs[i]);
		}

	}

}
