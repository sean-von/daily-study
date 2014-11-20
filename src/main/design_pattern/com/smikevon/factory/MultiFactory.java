package com.smikevon.factory;

public class MultiFactory {

	public Sender getMailSender(){
		return new MailSender();
	}

	public Sender getSmsSender(){
		return new SmsSender();
	}

}
