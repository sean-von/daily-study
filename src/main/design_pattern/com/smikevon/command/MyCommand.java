package com.smikevon.command;

public class MyCommand implements Command {

	private Receiver receiver;

	MyCommand(Receiver receiver){
		this.receiver = receiver;
	}

	public void execute() {
		receiver.action();
	}

}
