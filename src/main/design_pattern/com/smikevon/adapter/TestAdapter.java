package com.smikevon.adapter;

public class TestAdapter {

	public static void main(String[] args) {
		testAdapter();

		testWrapper();

		testAbstractWrapper();
	}

	public static void testAdapter(){
		Targetable target = new Adapter();
		target.method1();
		target.method2();
	}

	public static void testWrapper(){
		Source source= new Source();
		Targetable target = new Wrapper(source);
		target.method1();
		target.method2();
	}

	public static void testAbstractWrapper(){
		Sourceable sub1 = new SourceSub1();
		sub1.method1();
		sub1.method2();

		Sourceable sub2 = new SourceSub2();
		sub2.method1();
		sub2.method2();
	}

}

/**
 * 讲了这么多，总结一下三种适配器模式的应用场景：
 * 类的适配器模式：当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可。
 * 对象的适配器模式：当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，持有原类的一个实例，在Wrapper类的方法中，调用实例的方法就行。
 * 接口的适配器模式：当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，实现所有方法，我们写别的类的时候，继承抽象类即可。
 */
