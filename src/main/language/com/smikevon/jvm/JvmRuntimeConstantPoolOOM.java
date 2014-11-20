package com.smikevon.jvm;

import java.util.LinkedList;
import java.util.List;

public class JvmRuntimeConstantPoolOOM {

	private int runtimeConstantCount = 1;

	public static void main(String[] args) {
		JvmRuntimeConstantPoolOOM jvm = new JvmRuntimeConstantPoolOOM();
		jvm.execute();
	}

	public void execute(){
		try {
			runtimeConstantLeak();
		} catch (Exception e) {
			System.out.println("runtimeConstantCount : " + runtimeConstantCount);
			e.printStackTrace();
		}
	}

	private void runtimeConstantLeak(){
		List<String> list = new LinkedList<String>();
		while(true){
			String tmp = ("徐怀钰疑因拒绝公司安排的“陪酒”而被封杀雪藏"+new String(""+runtimeConstantCount++)).intern();
			list.add(tmp);
		}
	}

}
