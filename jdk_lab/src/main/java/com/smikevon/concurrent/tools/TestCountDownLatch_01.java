package com.smikevon.concurrent.tools;

import java.util.concurrent.CountDownLatch;

/**
 * @description: 要求：妈妈炒菜，但是这个时候还没买菜，也没有酱油了。为了更快的吃上饭，妈妈，小明，小强，分别行动，
 * 				 妈妈负责敲响做饭铃（铃响之前不许动），兄弟二人就可以出发，然后妈妈收拾厨房调好料，小明负责买菜，小强负责买酱油，协作完成此项工作
 *
 * 				 CountDownLatch 保证了其他线程执行完，才开始主线程.
 * 				 特点：所有的其他线程执行完，执行目标线程（即执行了await的线程）
 * @author     : fengxiao
 * @date       : 2014年9月17日 下午2:41:50
 */
public class TestCountDownLatch_01 {

	public static void main(String[] args) {

		//响铃的次数
		final int BellRingCount = 1;
		//需要买菜的次数
		final int MaterialCount = 1;
		//需要买酱油的次数
		final int SoysauceCount = 1;

		final CountDownLatch bellRingLatch = new CountDownLatch(BellRingCount);
		final CountDownLatch buyMaterialLatch = new CountDownLatch(MaterialCount);
		final CountDownLatch buySoySauceLath = new CountDownLatch(SoysauceCount);

		new Thread(new Runnable() {
			public void run() {
				try {
					System.out.println("准备做饭了哦！");
					System.out.println("ding ding ding !!!");

					/**
					 * 这条代码和下面的顺序颠倒就会导致死锁
					 */
					bellRingLatch.countDown();
					//等待菜和酱油都买回来了
					buyMaterialLatch.await();
					buySoySauceLath.await();

					System.out.println("我是妈妈，菜和酱油都齐了，我开始做饭喽！");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		},"妈妈").start();

		//小明等待铃响就去买菜
		new Thread(new Runnable() {
			public void run() {
				try {
					System.out.println("我是小明,我准备去买菜（to go）！");
					bellRingLatch.await();
					System.out.println("我是小明,我已经买到了菜（get back）！");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				buyMaterialLatch.countDown();
			}
		},"小明").start();

		new Thread(new Runnable() {
			public void run() {
				try {
					System.out.println("我是小强，我准备去打酱油（to go）！");
					bellRingLatch.await();
					System.out.println("我是小强，我已经打到了酱油（get back）！");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				buySoySauceLath.countDown();
			}
		},"小强").start();

	}

}
