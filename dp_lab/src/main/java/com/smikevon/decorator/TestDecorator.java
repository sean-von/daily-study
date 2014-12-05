package com.smikevon.decorator;

import com.smikevon.adapter.Sourceable;

public class TestDecorator {

	public static void main(String[] args) {
		Sourceable source = new Source();

		Sourceable decorator = new Decorator(source);

		decorator.method1();
	}

}
