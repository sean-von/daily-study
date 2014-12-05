package com.smikevon.observer;

import java.util.Iterator;
import java.util.Vector;

/**
 * @description: 观察者模式很好理解，类似于邮件订阅和RSS订阅，当我们浏览一些博客或wiki时，经常会看到RSS图标，就这的意思是，当你订阅了该文章，如果后续有更新，会及时通知你。
 * 				 其实，简单来讲就一句话：当一个对象变化时，其它依赖该对象的对象都会收到通知，并且随着变化！对象之间是一种一对多的关系
 * @author     : fengxiao
 * @date       : 2014年10月28日 下午3:52:56
 */
public abstract class AbstractSubject implements Subject {

	private Vector<Observer> vector = new Vector<Observer>();

	public void add(Observer observer) {
		vector.add(observer);
	}

	public void del(Observer observer) {
		vector.remove(observer);
	}

	public void notifyObservers() {
		Iterator<Observer> iterator = vector.iterator();
		while(iterator.hasNext()){
			Observer obj = iterator.next();
			obj.update();
		}
	}

}