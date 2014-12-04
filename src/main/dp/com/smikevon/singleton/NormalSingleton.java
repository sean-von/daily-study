package com.smikevon.singleton;

/**
 * @description: 简单的单例实现类
 * @author     : fengxiao
 * @date       : 2014年10月27日 下午2:36:22
 */
public class NormalSingleton {

	//持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载
	private static NormalSingleton instance = null;

	//似有构造方法，防止被实例化
	private NormalSingleton(){
	}

	//静态方法创建实例
	public static NormalSingleton getInstance(){
		if(instance == null){
			instance = new NormalSingleton();
		}
		return instance;
	}

}
