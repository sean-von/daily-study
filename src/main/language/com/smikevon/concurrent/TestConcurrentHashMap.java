package com.smikevon.concurrent;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {

	public static void main(String[] args) {

		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String,Object>();

		map.put("a", new String("a"));

		System.out.println(map.get("a"));

		Hashtable<String, Object> table = new Hashtable<String,Object>();

		System.out.println(table.size());

		HashMap<String, Object> hashmap = new HashMap<String,Object>();

		System.out.println(hashmap);

	}

}

class Dog{
	protected String name = "wangwang";
}
