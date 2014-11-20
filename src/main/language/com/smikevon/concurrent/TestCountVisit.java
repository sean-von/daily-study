package com.smikevon.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class TestCountVisit {

	public static void main(String[] args) throws InterruptedException {

		MyCount instance1 = new MyCount();

		Thread a = new Thread(instance1,"线程a");
		Thread b = new Thread(instance1,"线程b");
		a.start();
		b.start();
		a.join();
		b.join();

		MyCount instance2 = new MyCount();
		Thread c = new Thread(instance2,"线程c");
		c.start();
		c.join();

		for(int i=0;i<100;i++){
			Thread tmp = new Thread(instance2);
			tmp.start();
		}

		Thread.sleep(5000);

		System.out.println(MyCount.count);



	}

}

class MyCount implements Runnable{

	public static AtomicInteger count = new AtomicInteger(0);

	public void run() {
		for(int i=0;i<10;i++){
			count.incrementAndGet();
		}
	}

}
