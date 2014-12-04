package com.smikevon.chain;

public class MyHandler extends AbstractHandler {

	private String name;

	public MyHandler(String name){
		this.name = name;
	}

	@Override
	public void operate() {
		System.out.println(name+"deal!");
		if(getHandler()!=null){
			getHandler().operate();
		}
	}

}
