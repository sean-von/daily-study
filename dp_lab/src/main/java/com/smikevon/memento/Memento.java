package com.smikevon.memento;

/**
 * @description: 备忘录模式，主要目的是保存一个对象的某个状态，以便在适当的时候恢复对象，个人觉得叫备份模式更形象些，通俗的讲下：
 * 				 假设有原始类A，A中有各种属性，A可以决定需要备份的属性，备忘录类B是用来存储A的一些内部状态，类C呢，就是一个用来存储备忘录的，且只能存储，不能修改等操作
 * @author     : fengxiao
 * @date       : 2014年10月28日 下午8:22:01
 */
public class Memento {

	private String value;

	Memento(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
