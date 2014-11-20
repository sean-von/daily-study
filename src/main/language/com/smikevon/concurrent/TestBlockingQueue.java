package com.smikevon.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class TestBlockingQueue{

	final BlockingQueue<String> queue = new LinkedBlockingDeque<String>();

	public void printTheQueue() throws InterruptedException{

		String info = queue.take();

		System.out.println("获取的信息是:"+info);
	}

	public static void main(String[] args) throws InterruptedException {

		final TestBlockingQueue instance = new TestBlockingQueue();

		//第一个线程去获取queue中数据
		new Thread(new Runnable() {
			public void run() {
				try {
					System.out.println("我已经启动喽！A");
					instance.printTheQueue();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				try {
					System.out.println("我已经启动喽！B");
					Thread.sleep(3000);
					instance.queue.put("测试");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

}
