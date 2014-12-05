package com.smikevon.adapter;

/**
 * @description: 对象的适配器模式
 * @author     : fengxiao
 * @date       : 2014年10月27日 下午4:20:24
 */
public class Wrapper implements Targetable {

	private Source source;

	public Wrapper(Source source){
		this.source = source;
	}

	public void method1() {
		source.method1();
	}

	public void method2() {
		System.out.println("this is the targetable method2 ... ");
	}

}
