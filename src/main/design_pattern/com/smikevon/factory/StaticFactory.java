package com.smikevon.factory;

public class StaticFactory {

	public static Sender getMailSender(){
		return new MailSender();
	}

	public static Sender getSmsSender(){
		return new SmsSender();
	}

}
