package com.smikevon.singleton;

/**
 * @description: 真正线程安全的单例实现
 * @author     : fengxiao
 * @date       : 2014年10月27日 下午2:50:29
 */
public class RealSafeSingleton {

	private RealSafeSingleton(){
	}

	/**
	 * @description: jvm内部机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的
	 * @author     : fengxiao
	 * @date       : 2014年10月27日 下午2:51:22
	 */
	private static class RealSafeSingletonHolder{
		public static RealSafeSingleton singleton = new RealSafeSingleton();
	}

	public static RealSafeSingleton getInstance(){
		return RealSafeSingletonHolder.singleton;
	}

}

/*
 * 单例模式使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的。
 * 这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕，
 * 这样我们就不用担心上面的问题。同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题
 */