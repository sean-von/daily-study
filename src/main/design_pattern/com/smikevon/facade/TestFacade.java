package com.smikevon.facade;

public class TestFacade {

	public static void main(String[] args) {
		ComputerFacade computer = new ComputerFacade();
		computer.startup();

		computer.shutdown();
	}



}
