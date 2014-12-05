package com.smikevon.concurrent;

public class TestWaitAndNotify_03 {

	public static void main(String[] args) throws InterruptedException{
		ThreadD d = new ThreadD();
		d.start();

		System.out.println("total的最终计算结果");
		System.out.println(d.total);

		TestWaitAndNotify_03 test = new TestWaitAndNotify_03();
		test.testWait();

	}

	/**
	 * @Description: 当一个线程调用wait方法，它必须获取方法所属对象的锁（monitor），
	 * 				 否则会抛出异常，加上synchronized关键字是获取锁的简单方法。
	 * @throws InterruptedException
	 * @returType:void
	 */
	public synchronized void testWait() throws InterruptedException {
		System.out.print("测试直接调用wait：");
		wait();
	}
}

class ThreadD extends Thread{
	int total;

	public void run() {
			for(int i=0;i<100;i++){
				total += i;
			}
	}

}
