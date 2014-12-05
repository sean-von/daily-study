package com.smikevon.concurrent;


/**
 * @description: 线程死锁：线程A（friendA 代表的）在执行bow()后需执行bowBack，这时候需要线程获取对象friendB的锁，
 * 				 而与此同时对象friendB的锁在线程B的手中，且同样需要bowBack，即获取对象friendA的锁，即两个线程各自
 * 				 占有一个锁，又同时需要获取对方的锁才能操作完毕，故造成死锁。
 * @author     : fengxiao
 * @date       : 2014年9月12日 上午10:48:10
 */
public class TestDeadLock {

	static class Friend{
		private  String name ;
		public Friend(String name){
			this.name = name;
		}

		public String getName(){
			return name;
		}

		public synchronized void bow(Friend bower){
			System.out.format("%s: %s"+" has bowed to me %n",this.name,bower.getName());
			bower.bowBack(this);
		}

		private synchronized void bowBack(Friend bower) {
			System.out.format("%s: %s"+" has bowed backed to me %n",this.name,bower.getName());
		}

	}

	public static void main(String[] args) {

		final Friend friendA = new Friend("friendA");

		final Friend friendB = new Friend("friendB");

		new Thread(new Runnable() {
			public void run() {
				friendA.bow(friendB);
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				friendB.bow(friendA);
			}
		}).start();


	}

}
