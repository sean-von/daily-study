package com.smikevon.concurrent.tools;

import java.util.concurrent.Exchanger;

/**
 * @description: 交换工具，支持两个线程的数据交换，在一个线程调用了exchange方法后本身进入阻塞状态，等待另一个线程也执行了exchange方法
 * 				 重新模拟下生产者消费者
 * @author     : fengxiao
 * @date       : 2014年9月18日 下午4:08:27
 */
public class TestExchanger {

	public static void main(String[] args) {

		final String[] infos = {"我是","一名","工程师","工作于广阔的天地","这里有蓝天","还有绿地","学习english","but","all the info","is","fake","END"};
		final Exchanger<String> exchanger = new Exchanger<String>();

		new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<infos.length;i++){
					String message = infos[i];
					try {
						//交换回来的信息并未用到 String back = exchanger.exchange(message);
						exchanger.exchange(message);
						doing("发送信息---"+message);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		},"生产者").start();

		new Thread(new Runnable() {
			public void run() {
				try {
					String message = "";
					do{
						message = exchanger.exchange("");
						doing("收到信息---"+message);
					}while(!message.equals("END"));


				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"消费者").start();

	}

	/**
	 * @Description:打印出线程的名字
	 * @param msg
	 * @returType:void
	 */
	public static void doing(String msg){
		System.out.println(Thread.currentThread().getName()+":"+msg);
	}

}
