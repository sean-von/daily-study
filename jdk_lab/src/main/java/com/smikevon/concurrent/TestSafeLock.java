package com.smikevon.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class TestSafeLock {

	static class Friend{
		private String name;
		private ReentrantLock lock = new ReentrantLock();

		public String getName() {
			return name;
		}

		public Friend(String name){
			this.name = name;
		}

		public boolean impendingBow(Friend friend){
			boolean mylock = false;
			boolean yourlock = false;
			try{
				mylock = lock.tryLock();
				yourlock = friend.lock.tryLock();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(!(mylock && yourlock)){
					if(mylock){
						System.out.println("现在锁的状态1(mylock):"+lock.tryLock());
						lock.unlock();
						System.out.println("现在锁的状态2(mylock):"+lock.tryLock());
					}
					if(yourlock){

						System.out.println("现在锁的状态(yourlock):"+friend.lock.tryLock());
						friend.lock.unlock();

					}
				}
			}
			return mylock && yourlock;
		}

		public void bow(Friend friend){
			if(impendingBow(friend)){
				try{
					System.out.format("%s:%s has bow to %s %n", name,name,friend.getName());
					friend.bowBack(this);
				}finally{
					lock.unlock();
					friend.lock.unlock();
				}
			}else{
				System.out.format("%s:I found I have bowed to %s %n", name,friend.getName());
			}

		}

		public void bowBack(Friend friend){
			System.out.format("%s:%s has bowed back to me(%s) %n", name,friend.getName(),name);
		}
	}

	static class bowloop implements Runnable{

		private Friend friendA;
		private Friend friendB;

		public bowloop(Friend friendA, Friend friendB) {
			this.friendA = friendA;
			this.friendB = friendB;
		}



		public void run() {
			while(true){
				try {
					Thread.sleep(500);
					friendA.bow(friendB);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

	public static void main(String[] args) {
		Friend Sean = new Friend("Sean");
		Friend Tom = new Friend("Tom");

		new Thread(new bowloop(Sean, Tom)).start();
		new Thread(new bowloop(Tom, Sean)).start();

	}

}
