package com.smikevon.bridge;

public class TestBridge {

	public static void main(String[] args) {
		Bridge bridge = new MyBirdge();

		Sourceable source1 = new SourceSub1();
		bridge.setSource(source1);
		bridge.method();

		Sourceable source2 = new SourceSub2();
		bridge.setSource(source2);
		bridge.method();
	}

}
