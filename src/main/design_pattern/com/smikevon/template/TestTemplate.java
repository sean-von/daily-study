package com.smikevon.template;

public class TestTemplate {

	public static void main(String[] args) {
		Template template = new Plus();
		System.out.println(template.calculate("2+6", "\\+"));
	}

}
