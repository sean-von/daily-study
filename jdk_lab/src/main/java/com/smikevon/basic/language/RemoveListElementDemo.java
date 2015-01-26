package com.smikevon.basic.language;

import java.util.ArrayList;
import java.util.List;

public class RemoveListElementDemo {
    private static  List<Integer> integerList;

    static {
        integerList = new ArrayList<Integer>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
    }

    public static void remove(Integer remove) {
        for(Integer integer : integerList) {
            if(integer.equals(remove)) {
                integerList.remove(integer);
            }
        }
    }

    public static void main(String... args) {
        remove(Integer.valueOf(2));

        Integer remove = Integer.valueOf(3);
        for(Integer integer : integerList) {
            if(integer.equals(remove)) {
                //integerList.remove(integer);
                integerList.add(5);
                        
            }
        }
    }
}