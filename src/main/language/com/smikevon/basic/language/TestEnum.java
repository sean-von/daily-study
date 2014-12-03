package com.smikevon.basic.language;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 冯枭 E-mail:fengxiao@xiaomi.com
 * @since 创建时间: 14-11-28 下午2:07
 */
public class TestEnum {

    enum Operator{
        PLUS("+") {
            double apply(double x, double y) {
                return x+y;
            }
        },
        MINUS("-") {
            double apply(double x, double y) {
                return x-y;
            }
        },
        TIMES("*") {
            double apply(double x, double y) {
                return x*y;
            }
        },
        DIVIDE("/") {
            @Override
            double apply(double x, double y) {
                return x/y;
            }
        };

        private final String op;
        Operator(String op){
            this.op = op;
        }

        abstract double apply(double x,double y);

        //默认返回枚举名字
        public String toString(){
            return op;
        }

        //保存重写toString后，string到原enum名的映射
        private static final Map<String,Operator> stringToEnum = new HashMap<String, Operator>();
        static {
            for(Operator op : Operator.values()){
                stringToEnum.put(op.toString(),op);
            }
        }

        public Operator fromString(String s){
            return stringToEnum.get(s);
        }
    }

    public static void main(String[] args){
        System.out.println(Operator.values());
        System.out.println(Operator.DIVIDE.apply(4,3));
        System.out.println(Operator.DIVIDE);

        System.out.println(Operator.valueOf("MINUS"));
    }

}
