package com.smikevon.jvm;

import java.util.Random;

public class TestRandom {

	private static final int MAX_SIZE = 999999999;
	private static final int MIN_SIZE = 999999;
	public int a;
	public static final int c = 3;

	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub

		for(int i=0;i<100;i++){
			Thread.sleep(1000);
			System.out.println(getRandomInt(MAX_SIZE-MIN_SIZE+1)+MIN_SIZE);
		}

		TestRandom test = new TestRandom();


		System.out.println(test.a);

	}

	private static int getRandomInt(int range){
		Random random = new Random(System.currentTimeMillis());
		return random.nextInt(range);
	}

}
