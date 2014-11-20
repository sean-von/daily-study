package com.smikevon.factory;

/**
 * @description: 凡是出现了需要大量产品需要创建，并且有共同的接口时，可以通过工厂方法模式进行创建，在以下的三种模式中，第一种如果传入的字符串有误，
 * 				 不能正确创建，第三种相对于第二种，不需要实例化工厂类，大多数情况下，我们会选用第三中---静态工厂方法模式
 * @author     : fengxiao
 * @date       : 2014年10月27日 上午11:20:28
 */
public class FactoryTest {

	public static void main(String[] args) {
		testNormalFactory();

		testMultiFactory();

		testStaticFactory();
	}

	/**
	 * @Description:测试普通工厂方法
	 * @returType:void
	 */
	public static void testNormalFactory(){
		NormalFactory nf = new NormalFactory();
		Sender sender = nf.produce("mail");
		sender.send();
	}

	/**
	 * @Description:测试多个工厂方法模式
	 * @returType:void
	 */
	public static void testMultiFactory(){
		MultiFactory factory = new MultiFactory();
		Sender sender = factory.getSmsSender();
		sender.send();
	}

	/**
	 * @Description:测试静态工厂模式
	 * @returType:void
	 */
	public static void testStaticFactory(){
		Sender sender = StaticFactory.getMailSender();
		sender.send();
	}

}
