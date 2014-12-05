package com.smikevon.template;

public class Plus extends Template {

	public int calculate(int num1, int num2) {
		System.out.println("调用了子类的覆盖方法");
		return num1 + num2;
	}

}
