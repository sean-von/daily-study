package com.smikevon.basic.interview;

import com.smikevon.basic.interview.FruitColor.Color;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestAnnoation {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Apple apple = new Apple();

		System.out.println(apple.color);


		Method method = Apple.class.getMethod("getColor");
		FruitColor annotation = method.getAnnotation(FruitColor.class);

		Color color = annotation.fruitColor();

		String info = "";
		switch (color) {
		case RED:
			info = "红色";
			break;
		case BLUE:
			info = "蓝色";
			break;
		case GREEN:
			info = "绿色";
			break;
		default:
			break;
		}
		apple.color = info;
		//annotation

		method.invoke(apple);

		
	}

}

class Apple{


	public String color;

	@FruitColor(fruitColor= Color.RED)
	public String getColor(){
		System.out.println(color);
		return color;
	}

}

