package com.smikevon.jvm;

import java.util.HashMap;
import java.util.Map;

public class TestInteger {

	public static void main(String[] args) {

		Integer a1 = new Integer(30);

		Integer a2 = new Integer(30);

		System.out.println(a1.intValue() == a2.intValue());

		System.out.println(a2.equals(30));

		Map<Position, String> map = new HashMap<Position,String>();

		Position position = new Position(3);

		map.put(position, "你好啊");

		System.out.println(map.get(position));

		System.out.println(map.get(new Position(3)));

		System.out.println(new Integer("32").hashCode());
		System.out.println(new Integer("32").hashCode());
		System.out.println(new String("a").hashCode());
	}

}

class Position{
	int value ;

	public Position(int value) {
		super();
		this.value = value;
	}

}
