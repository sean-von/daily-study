package com.smikevon.abstract_factory;

import com.smikevon.factory.Sender;
import com.smikevon.factory.SmsSender;

public class SmsFactory implements Provider {

	public Sender produce() {
		return new SmsSender();
	}

}
