package com.smikevon.proxy;

import com.smikevon.adapter.Sourceable;

public class TestProxy {

	public static void main(String[] args) {
		Sourceable proxy = new Proxy();

		proxy.method1();
	}

}
