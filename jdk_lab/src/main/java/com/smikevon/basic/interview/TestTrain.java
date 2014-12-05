package com.smikevon.basic.interview;

/**
 * @description: 你是山西的一个煤老板，你在矿区开采了有3000吨煤需要运送到市场上去卖，从你的矿区到市场有1000公里，
 * 				 你手里有一列烧煤的火车，这个火车最多只能装1000吨煤，且其能耗比较大——每一公里需要耗一吨煤。请问，
 * 				 作为一个懂编程的煤老板的你，你会怎么运送才能运最多的煤到集市？
 * @author     : fengxiao
 * @date       : 2014年9月30日 下午2:33:55
 */
public class TestTrain {

	public static int totalCoal = 3000;
	public static int totalLenth = 1000;
	public static final int MAX_LOAD = 1000;

	public static void main(String[] args) {
		System.out.println(getRemainCoal(3000, 1000));
	}

	/**
	 * @Description:思路就是第一次将所有煤运到一个中间点B，假设起点是A，将所有运到B 后煤的总量是正好少一次运输全运完，每次递归少运一车皮，直到最后剩下的量一次能全运完。
	 * @param remainCoal
	 * @param remainLenth
	 * @return
	 * @returType:int
	 */
	public static int getRemainCoal(int remainCoal,int remainLenth){
		//计算本次递归还需要运输几次
		int times = remainCoal % MAX_LOAD == 0 ? remainCoal / MAX_LOAD : remainCoal / MAX_LOAD + 1;
		if(times == 1){
			return remainCoal - remainLenth;
		}
		return getRemainCoal(remainCoal-MAX_LOAD, remainLenth-(MAX_LOAD/(2*times-1)));
	}



}
