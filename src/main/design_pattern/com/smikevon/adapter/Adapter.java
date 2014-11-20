package com.smikevon.adapter;

/**
 * @description: 类的适配器模式
 * @author     : fengxiao
 * @date       : 2014年10月27日 下午4:08:53
 */
public class Adapter extends Source implements Targetable{

	public void method2() {
		System.out.println("this is the targetable method2 ...");
	}

}


/**
 * 核心思想就是：有一个Source类，拥有一个方法，待适配，目标接口时Targetable，通过Adapter类，将Source的功能扩展到Targetable里
 */