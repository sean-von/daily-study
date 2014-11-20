package com.smikevon.concurrent;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ProducerConsumer_04 {
	
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

}
