package com.smikevon.concurrent;

import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @description: 生产者消费者模式使用exchanger来实现
 * @author     : fengxiao
 * @date       : 2014年9月18日 下午4:28:49
 */
public class ProducerConsumer_02 {

	static class Producer implements Runnable {

		private Exchanger<String> exchanger;
		private String name;

		public Producer(Exchanger<String> exchanger,String name){
			this.exchanger = exchanger;
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
					System.out.format("%s: 放入信息-----------%s %n",name,messages[i]);
					exchanger.exchange(messages[i]);
					Thread.sleep(new Random(System.currentTimeMillis()).nextInt(5000));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class Consumer implements Runnable{

		private Exchanger<String> exchanger;
		private String name;

		public Consumer(Exchanger<String> exchanger,String name){
			this.exchanger = exchanger;
			this.name = name;
		}

		public void run() {
			try {
				String message = "";
				do{
					message = exchanger.exchange("");
					System.out.format("%s: 取出信息-------------%s %n",name,message);
					Thread.sleep(new Random(System.currentTimeMillis()).nextInt(5000));
				}while(!message.equals("done"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args){
		Executor executor = Executors.newCachedThreadPool();
		Exchanger<String> exchanger = new Exchanger<String>();
		executor.execute(new Producer(exchanger,"生产者"));
		executor.execute(new Consumer(exchanger,"消费者"));
	}

}
