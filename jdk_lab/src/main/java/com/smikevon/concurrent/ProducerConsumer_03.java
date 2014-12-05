package com.smikevon.concurrent;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @description: 生产者消费者模式，采用semaphore(信号量机制进行处理)
 * @author     : fengxiao
 * @date       : 2014年9月18日 下午4:52:09
 */
public class ProducerConsumer_03 {

	static class Producer implements Runnable {

		private Drop drop;
		private Semaphore producerSemaphore;
		private Semaphore consumerSemaphore;
		private String name;

		public Producer(Drop drop,Semaphore producerSemaphore,Semaphore consumerSemaphore,String name){
			this.drop = drop;
			this.producerSemaphore = producerSemaphore;
			this.consumerSemaphore = consumerSemaphore;
			this.name = name;
		}

		public void run() {
			String[] messages = {
				"我是",
				"一名程序员",
				"我很骄傲",
				"也很自豪",
				"爱岗敬业",
				"勤劳奉献",
				"无怨无悔",
				"奉献青春",
				"希望通过学习",
				"提升",
				"自己",
				"done",
			};
			try {
				for(int i=0;i<messages.length;i++){
					producerSemaphore.acquire();
					System.out.format("%s: 放入信息-----------%s %n",name,messages[i]);
					Thread.sleep(new Random(System.currentTimeMillis()).nextInt(5000));
					drop.setMessage(messages[i]);
					consumerSemaphore.release();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	static class Consumer implements Runnable{

		private Drop drop;
		private Semaphore producerSemaphore;
		private Semaphore consumerSemaphore;
		private String name;

		public Consumer(Drop drop,Semaphore producerSemaphore,Semaphore consumerSemaphore,String name){
			this.drop = drop;
			this.producerSemaphore = producerSemaphore;
			this.consumerSemaphore = consumerSemaphore;
			this.name = name;
		}

		public void run() {
			try {
				String message = "";
				do{
					consumerSemaphore.acquire();
					message = drop.getMessage();
					System.out.format("%s: 取出信息-------------%s %n",name,message);
					Thread.sleep(new Random(System.currentTimeMillis()).nextInt(5000));
					producerSemaphore.release();
				}while(!message.equals("done"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class Drop{
		String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}

	public static void main(String[] args){
		Drop drop = new Drop();
		Semaphore producerSemaphore = new Semaphore(1);
		Semaphore consumerSemaphore = new Semaphore(0);

		Executor executor = Executors.newCachedThreadPool();
		executor.execute(new Producer(drop, producerSemaphore, consumerSemaphore, "生产者"));
		executor.execute(new Consumer(drop, producerSemaphore, consumerSemaphore, "消费者"));

	}

}
