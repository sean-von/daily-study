package com.smikevon.mediator;

public class TestMediator {

	public static void main(String[] args) {
		Mediator mediator = new MyMediator();
		mediator.createMediator();
		mediator.workAll();
	}

}
