package com.smikevon.composite;

public class TestTree {

	public static void main(String[] args) {
		TreeNode nodeA = new TreeNode("A");
		TreeNode nodeB = new TreeNode("B");
		TreeNode nodeC = new TreeNode("C");

		nodeB.add(nodeC);

		nodeA.add(nodeB);
	}

}
