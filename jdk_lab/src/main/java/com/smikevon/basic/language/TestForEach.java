package com.smikevon.basic.language;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 冯枭 E-mail:fengxiao@xiaomi.com
 * @since 创建时间: 14-12-2 下午7:37
 */
public class TestForEach {

    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException,
                   InvocationTargetException {

        List<Dog> list = new LinkedList<Dog>();
        list.add(new Dog("wangA",2));
        list.add(new Dog("wangB",3));
        list.add(new Dog("wangC",4));
        list.add(new Dog("wangD",5));
        list.add(new Dog("wangE",6));
        list.add(new Dog("wangF",7));
        list.add(new Dog("wangG",8));

        for(Iterator<Dog> iterator = list.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
            iterator.remove();
        }
        /*
        System.out.println("");

        //for-each 代码不允许出现删除，如果删除就会抛出异常
        for(Dog dog : list){
            *//*if(dog.name.equals("wangC")){
                list.remove(dog);
            }*//*

            //发现更新数据是生效的，也就是dog是list中元素的一个引用，而不是拷贝
            if(dog.name.equals("wangC")){
                dog.setName("wang8");
            }
        }

        for(Dog dog : list){
            System.out.println(dog);
        }*/


        Class<TestMoney> dog2 = (Class<TestMoney>) Class.forName("com.smikevon.basic.language.TestMoney");

        Method method = dog2.getMethod("getMoney",Double.class);

        BigDecimal value =  (BigDecimal)method.invoke(dog2.newInstance(),22d);

        System.out.println(value);

    }

    static class Dog{
        private String name;
        private int age;

        Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Dog dog = (Dog) o;

            if (age != dog.age) return false;
            if (name != null ? !name.equals(dog.name) : dog.name != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
