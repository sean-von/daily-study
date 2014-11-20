package com.smikevon.concurrent;

public class TestThread {

	public static void main(String[] args) {
		JobA a = new JobA();
		new Thread(a).start();

		JobB b = new JobB();
		b.start();
	}

}

class JobA implements Runnable{

	public void run() {
		System.out.println("I am Job A");
	}

}

class JobB extends Thread{

	public void run() {
		System.out.println("I am Job B");
	}

}