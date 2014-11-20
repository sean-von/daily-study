package com.smikevon.concurrent;

import java.util.Random;

/**
 * @description: 生产者消费者模式,通过wait和notify方式来实现
 * @author     : fengxiao
 * @date       : 2014年9月12日 上午11:39:31
 */
public class ProducerConsumer_01 {

	public static void main(String[] args) {
		Drop drop = new Drop();
		new Thread(new Producer(drop)).start();
		new Thread(new Consumer(drop)).start();
	}

}

/**
 * @description: 传送带，只能有一个物品（message）在上面
 * @author     : fengxiao
 * @date       : 2014年9月12日 下午12:03:08
 */
class Drop{

	private String message;
	private boolean empty = true;

	public synchronized String take() throws InterruptedException{
		while(empty){
			wait();
		}
		empty = true;
		notifyAll();
		return message;
	}

	public synchronized void put(String message) throws InterruptedException{
		while(!empty){
			wait();
		}
		this.message = message;
		empty = false;
		notifyAll();
	}

}

/**
 *
 * @description: 生产者随机放入字符串
 * @author     : fengxiao
 * @date       : 2014年9月12日 上午11:53:27
 */
class Producer implements Runnable {

	private Drop drop;

	public Producer(Drop drop) {
		this.drop = drop;
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
				System.out.format("%s: 放入信息-----------%s %n",Thread.currentThread().getName(),messages[i]);
				drop.put(messages[i]);
				Thread.sleep(new Random(System.currentTimeMillis()).nextInt(5000));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

/**
 * @description: 消费者，有字符串，就取出来
 * @author     : fengxiao
 * @date       : 2014年9月12日 下午12:02:35
 */
class Consumer implements Runnable{

	private Drop drop;

	Consumer(Drop drop){
		this.drop = drop;
	}

	public void run() {
		try {
			String message = "";
			System.out.println(drop);
			while(!(message = drop.take()).equals("done")){
				System.out.format("%s: 取出信息-------------%s %n",Thread.currentThread().getName(),message);
				Thread.sleep(new Random(System.currentTimeMillis()).nextInt(5000));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}