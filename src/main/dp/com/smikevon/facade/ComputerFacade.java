package com.smikevon.facade;

/**
 * @description: 外观模式是为了解决类与类之家的依赖关系的，像spring一样，可以将类和类之间的关系配置到配置文件中，
 * 				 而外观模式就是将他们的关系放在一个Facade类中，降低了类类之间的耦合度，该模式中没有涉及到接口
 * @author     : fengxiao
 * @date       : 2014年10月27日 下午5:31:03
 */
public class ComputerFacade {
	private Cpu cpu;
	private Memory memory;
	private Disk disk;

	ComputerFacade(){
		this.cpu = new Cpu();
		this.memory = new Memory();
		this.disk = new Disk();
	}

	public void startup(){
		System.out.println("start the computer ... ");
		cpu.startup();
		memory.startup();
		disk.startup();
		System.out.println("start computer finished ...");
	}

	public void shutdown(){
		System.out.println("shutdown the computer ...");
		cpu.shutdown();
		memory.shutdown();
		disk.shutdown();
		System.out.println("shutdown computer finished ...");
	}
}
