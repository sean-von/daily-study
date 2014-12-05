package com.smikevon.concurrent;

public class TestWaitAndNotify_02 {

	public static void main(String[] args) throws InterruptedException{
		ThreadC c = new ThreadC();
		c.start();

		System.out.println("total的最终计算结果");
		System.out.println(c.total);
	}
}

class ThreadC extends Thread{
	int total;

	public void run() {
			for(int i=0;i<100;i++){
				total += i;
			}
	}

}
