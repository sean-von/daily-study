package com.smikevon.abstract_factory;

import com.smikevon.factory.MailSender;
import com.smikevon.factory.Sender;

public class MailFactory implements Provider {

	public Sender produce() {
		return new MailSender();
	}

}
