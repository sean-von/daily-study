package com.smikevon.jvm;

/**
 * @description: 字符串的不同
 * @author     : fengxiao
 * @date       : 2014年8月19日 下午5:35:02
 */
public class StringPool {

	public static void main(String[] args) {

		/**
		 *  jvm会首先在内部维护的strings pool中通过string的equals方法查找对象池中是否存放有该String对象，
		 *  如果有则返回已有的string对象给用户，而不会在heap中重新创建一个新的String对象；如果对象池中没有该
		 *  String对象，jvm则在heap中创建新的String对象，将其引用返回给用户，同时将引用添加至strings pool中
		 */
		String s1 = "小鸟(small bird)";
		String s2 = "小鸟(small bird)";

		/**
		 *  jvm会对+进行优化，两边都是字符串常量，则进行类似于对上面s1的处理。
		 */
		String s3 = "小鸟" + "(small bird)";

		/**
		 *  对于这种，jvm会马上在heap中创建一个对象，然后将对象的引用返回给用户，这种程序不会主动将对将放到
		 *  strings pool里面的，除非程序调用String的intern 方法。
		 */
		String s4 = new String("小鸟(small bird)");

		/**
		 * 如果+的任意一边是一个变量，就会做类似 new String() 的处理
		 */
		String s5 = "小鸟" + new String("(small bird)");
		String s6 = s4.intern();

		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s2 == s3);
		System.out.println(s1 == s4);
		System.out.println(s1 == s5);
		System.out.println(s4 == s5);
		System.out.println(s1 == s6);

		System.out.println("========================");

		String a = new String("test");
		String b = new String("test");
		System.out.println(a == b);
		System.out.println(a.intern() == b.intern());

	}

}
