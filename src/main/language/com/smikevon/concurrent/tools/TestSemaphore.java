package com.smikevon.concurrent.tools;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @description: 有A,B,C三个线程, A线程输出A, B线程输出B, C线程输出C.要求, 同时启动三个线程, 按顺序输出ABC, 循环10次
 * @author     : fengxiao
 * @date       : 2014年9月17日 下午8:23:05
 */
public class TestSemaphore {

	public static void main(String[] args) {

		final Semaphore sa = new Semaphore(1);
		final Semaphore sb = new Semaphore(0);
		final Semaphore sc = new Semaphore(0);

		final Random random = new Random(System.currentTimeMillis());

		new Thread(new Runnable() {
			public void run() {
				try {
					while(true){
						Thread.sleep(random.nextInt(3000));
						sa.acquire();
						doing("A");
						sb.release();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"线程a").start();

		new Thread(new Runnable() {
			public void run() {
				try {
					while(true){
						Thread.sleep(random.nextInt(3000));
						sb.acquire();
						doing("B");
						sc.release();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"线程b").start();

		new Thread(new Runnable() {
			public void run() {
				try {
					while(true){
						Thread.sleep(random.nextInt(3000));
						sc.acquire();
						doing("C");
						sa.release();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"线程c").start();

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
