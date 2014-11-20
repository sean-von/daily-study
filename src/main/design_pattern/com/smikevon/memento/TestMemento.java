package com.smikevon.memento;

public class TestMemento {

	public static void main(String[] args){
		Original original = new Original("egg");

		Storage storage = new Storage(original.createMemento());

		System.out.println("初始化状态:"+original.getValue());

		original.setValue("niu");

		System.out.println("修改后状态:"+original.getValue());

		original.reloadMemento(storage.getMemento());

		System.out.println("恢复后状态:"+original.getValue());
	}

}
