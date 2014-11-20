package com.smikevon.basic.language;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class TestGenerics {

	public static void main(String[] args) {

		List<Timestamp> list = new LinkedList<Timestamp>();

		add(list, new Date());

		Set<String> set = new HashSet<String>();

		set.add(null);

		set.add(null);//set不允许重复

		System.out.println(set.size()+"====="+set.isEmpty());

		//线程安全的list
		Vector<String> vector = new Vector<String>();

		vector.add(null);//允许放入空值

		vector.add(null);//允许放入重复的值

		System.out.println(vector.size());



	}

	public static void add(List<? extends Date> list,Date date){

		//list.add(date); 会报错编译不通过

		list.add(null);
	}

	/**
	 * @Description:使用泛型方法，T作为一种参数化信息存储在java字节码中，T的实际类型由调用时的参数决定。
	 * @param list
	 * @param date
	 * @returType:void
	 */
	public  static <T extends Date> List<T> add2(List<T> list,T date){
		list.add(date);
		return list;
	}

	public static void add(List<? super Timestamp> list){
		Timestamp timestamp = new Timestamp(System.nanoTime());
		list.add(timestamp);
		/**
		 * List<? super Timestamp>表示这个list的参数类型可能是Timestamp或Timestamp的父类，如后面测试代码里，实际传入的是一个List<Date>类型。
		 * 向List<Date>中add一个Timestamp肯定是没有问题的，但list.get()方法返回的对象类型可能是Date甚至是Object，
		 * 你不能说list.get(0)返回的就是一个Timestamp，这里是向下类型转换了，编译器无法处理，所以这里不能编译
		 * @param <S>
		 * @param <S>
		 * @param <T>
		 */
		//Timestamp timestamp2 = list.get(0); 编译报错
	}



}
