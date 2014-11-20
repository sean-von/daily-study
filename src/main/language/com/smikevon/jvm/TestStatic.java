package com.smikevon.jvm;

import java.util.Random;

public class TestStatic {

	public static void main(String[] args) {

		//System.out.println(Child.m);

		Random random = new Random();
		StringBuffer sb = null;
		switch (random.nextInt(2)) {
		case 1: sb = new StringBuffer('p');
		case 2: sb = new StringBuffer('G');
		default:
			sb = new StringBuffer('M');
		}
		System.out.println(sb);
		sb.append("a");
		sb.append("i");
		sb.append("n");
		System.out.println(sb);
	}

}

interface Super{
	public static int m = 100;
}

class Parent{
	public static int m = 33;
	static {
		System.out.println("执行了父类静态语句块");
	}
}

class Child extends Parent implements Super {
	static {
		System.out.println("执行了子类静态语句块");
	}
}
