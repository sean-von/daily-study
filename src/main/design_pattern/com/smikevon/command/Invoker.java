package com.smikevon.command;

public class Invoker {

	private Command command;

	Invoker(Command command){
		this.command = command;
	}

	public void action(){
		command.execute();
	}

}
