package com.smikevon.jvm;

/**
 * Created by fengxiao on 14-12-26.
 */
public class JvmStack {

    public static void main(String[] args){
        testStackOverFlow(0);
    }

    public static void testStackOverFlow(int i){
        System.out.println(i++);
        testStackOverFlow(i);
    }

    public static void testStackOOM(){

    }
}
