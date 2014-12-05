package com.smikevon.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @description: 原型模式，虽然是创建型的模式，但是与工厂模式没有关系，从名字即可看出，该模式的思想就是将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象
 * @author     : fengxiao
 * @date       : 2014年10月27日 下午3:14:08
 */
public class Prototype implements Cloneable,Serializable{

	private static final long serialVersionUID = -7108927183454585244L;

	private String string;

	private SerializableObject object = null;

	/**
	 * 浅复制
	 */
	public Object clone() throws CloneNotSupportedException{
		Prototype prototype = (Prototype)super.clone();
		return prototype;
	}

	public Object deepClone() throws IOException, ClassNotFoundException{

		/**
		 * 写入当前对象的二进制流
		 */
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);

		/**
		 * 读出当前二进制流产生的新对象
		 */
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public SerializableObject getObject() {
		return object;
	}

	public void setObject(SerializableObject object) {
		this.object = object;
	}

}

class SerializableObject implements Serializable{
	private static final long serialVersionUID = 7410149633863564932L;
}

/**
 * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
 * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
 */
