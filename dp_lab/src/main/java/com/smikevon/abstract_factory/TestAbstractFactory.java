package com.smikevon.abstract_factory;

import com.smikevon.factory.Sender;

/**
 * @description: 抽象工厂,好处就是，如果你现在想增加一个功能：发及时信息，则只需做一个实现类，实现Sender接口，
 * 				 同时做一个工厂类，实现Provider接口，就OK了，无需去改动现成的代码。这样做，拓展性较好！
 * @author     : fengxiao
 * @date       : 2014年10月27日 上午11:36:11
 */
public class TestAbstractFactory {

	public static void main(String[] args) {
		Provider provider = new MailFactory();
		Sender sender = provider.produce();

		sender.send();
	}

}
