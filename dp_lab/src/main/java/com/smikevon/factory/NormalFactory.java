package com.smikevon.factory;

public class NormalFactory {

	public Sender produce(String type){
		if(type.equals("sms")){
			return new SmsSender();
		}else if(type.equals("mail")){
			return new MailSender();
		}else{
			System.out.println("请输入正确的类型");
			return null;
		}
	}

}
