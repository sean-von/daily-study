package com.smikevon.concurrent;

public class SimpleThread {

	public static void threadMessage(String message){
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName,message);
	}

	public static class MessageLoop implements Runnable{

		public void run() {
			String[] strs = {
					"我是",
					"中华人民共和国",
					"北京的",
					"一名普通公民"
				};

			try{
				for(int i=0;i<strs.length;i++){
					Thread.sleep(4000);
					threadMessage(strs[i]);
				}
			}catch(InterruptedException e){
				threadMessage("I wasn't done");
			}

		}

	}

	public static void main(String[] args) throws InterruptedException {

		//long pantience = 1000*60*60;

		long pantience = 1000*12;

		threadMessage("Starting MessageLoop thread");
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop());
		t.start();
		threadMessage("Waiting MessageLoop thread to finish");

		while(t.isAlive()){
			threadMessage("Still Waiting ...");
			t.join(1000);

			if(System.currentTimeMillis()-startTime>pantience && t.isAlive()){
				threadMessage("Tired of Waiting!");
				t.interrupt();
				t.join();
			}
		}
		threadMessage("Finally");

	}

}
