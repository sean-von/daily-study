package com.smikevon.basic.interview;

/**
 * @author 冯枭 E-mail:fengxiao@xiaomi.com
 * @since 创建时间: 14-11-17 上午10:01
 */
public class TestBasic {
    public static void main(String[] args){
        Cat robin = new Cat(5,"Robin");
        kill(robin);
        System.out.println(robin);

    }

    public static void kill(Cat cat){
        cat.setAge(-1);
        cat.setName("Dead Robin");
    }

    static class Cat{
        int age;
        String name;

        Cat(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "age=" + age +
                    ", name=" + name +
                    '}';
        }
    }
}
