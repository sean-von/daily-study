package com.smikevon.concurrent;

public class TestWaitAndNotify_01 {

	public static void main(String[] args) throws InterruptedException{
		ThreadB b = new ThreadB();
		b.start();

		/**
		 * 因为对b加了锁，并且对象调用了wait() 方法，故访问这段代码的线程会被挂起，直到此对象的其他线程调用notify()方法，才会继续执行。
		 */
		synchronized(b){
			System.out.println("total的最终计算结果");
			b.wait();
			System.out.println(b.total);
		}
	}
}

class ThreadB extends Thread{
	int total;

	public void run() {
		synchronized (this) {
			for(int i=0;i<100;i++){
				total += i;
			}
			notify();
		}
	}

}
