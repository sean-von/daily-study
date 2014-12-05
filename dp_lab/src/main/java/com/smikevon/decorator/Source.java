package com.smikevon.decorator;

import com.smikevon.adapter.Sourceable;

public class Source implements Sourceable {

	public void method1() {
		System.out.println("this is the source method1 ... ");
	}

	public void method2() {
		System.out.println("this is the source method2 ... ");
	}

}
