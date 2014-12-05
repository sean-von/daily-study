package com.smikevon.basic.language;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 冯枭 E-mail:fengxiao@xiaomi.com
 * @since 创建时间: 14-11-20 下午8:04
 */
public class TestStringPlus {
    public static void main(String[] args){
        String initial = "";
        long start = System.nanoTime();
        for(int i=0;i<10000;i++){
            initial = initial+"a";
        }
        long end = System.nanoTime();
        System.out.println(end-start);

        MemoryMXBean bean = ManagementFactory.getMemoryMXBean();
        MemoryUsage memoryUsage = bean.getHeapMemoryUsage();
        System.out.println(memoryUsage.getUsed());

        /*StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();
        for(int i=0;i<10000;i++){
            sb.append("b");
        }
        long end = System.nanoTime();
        System.out.println(end-start);
        MemoryMXBean bean = ManagementFactory.getMemoryMXBean();
        MemoryUsage memoryUsage = bean.getHeapMemoryUsage();
        System.out.println(memoryUsage.getUsed());*/

        int[][] array = new int[3][3];

        LinkedList<String>[][] array2 = new LinkedList[3][2];
    }
}
