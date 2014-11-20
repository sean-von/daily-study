package com.smikevon.observer;

public class MySubject extends AbstractSubject{

	public void operate() {
		System.out.println("do update");
		notifyObservers();
	}

}
