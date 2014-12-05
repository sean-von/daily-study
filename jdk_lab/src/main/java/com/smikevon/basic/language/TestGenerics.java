package com.smikevon.basic.language;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
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

        List<? super Integer>[] alist = new List[10];

        alist[0] = new LinkedList<Object>();

        List<String> clist = new LinkedList<String>();
        clist.toArray();

        Set<String> set1 = new HashSet<String>(Arrays.asList("a","b","c"));

        Set<String> set2 = new HashSet<String>(Arrays.asList("d","e","f","g"));

        Set<String> set3 = union(set1,set2);

        System.out.println(set3);
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

    public void testWildCard(){
        List<?> list = new ArrayList<String>();
        list.add(null);
        //list.add("abc");
    }

    public static <E> Set<E>  union(Set<E> e1,Set<E> e2){
        Set<E> set = new HashSet<E>(e1);
        set.addAll(e2);
        return set;
    }

    public static <k,v> HashMap<k,v> newHashmap(){
        return new HashMap<k, v>();
    }



}
