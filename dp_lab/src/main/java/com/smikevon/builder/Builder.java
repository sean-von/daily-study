package com.smikevon.builder;

import com.smikevon.factory.MailSender;
import com.smikevon.factory.Sender;
import com.smikevon.factory.SmsSender;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 建造者模式
 * @author     : fengxiao
 * @date       : 2014年10月27日 下午3:00:58
 */
public class Builder {

	private List<Sender> list = new LinkedList<Sender>();

	public void produceMailSender(int count){
		for(int i=0;i<count;i++){
			list.add(new MailSender());
		}
	}

	public void produceSmsSender(int count){
		for(int i=0;i<count;i++){
			list.add(new SmsSender());
		}
	}
}
