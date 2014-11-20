package com.smikevon.algorithm.basicSort;

import java.util.List;

public class BinaryTree {

	/**
	 * @description: 二叉树的数据结构
	 * @author     : fengxiao
	 * @date       : 2014年9月29日 上午11:28:33
	 */
	static class Node{
		private String data;
		private Node leftChild;
		private Node rightChild;

		public Node(String data) {
			this.data = data;
		}
		public String getData() {
			return data;
		}

		public Node getLeftChild() {
			return leftChild;
		}

		public Node getRightChild() {
			return rightChild;
		}
		public Node setLeftChild(Node leftChild) {
			this.leftChild = leftChild;
			return this;
		}
		public Node setRightChild(Node rightChild) {
			this.rightChild = rightChild;
			return this;
		}

	}

	public static void main(String[] args) {

		//构造一颗二叉树
		Node node_a = new Node("a");
		Node node_b = new Node("b");
		Node node_c = new Node("c");
		Node node_d = new Node("d");
		Node node_e = new Node("e");
		Node node_f = new Node("f");
		Node node_g = new Node("g");
		Node node_h = new Node("h");
		Node node_i = new Node("i");

		node_a.setLeftChild(node_b).setRightChild(node_c);
		node_b.setLeftChild(node_d).setRightChild(node_e);
		node_c.setLeftChild(node_f).setRightChild(node_g);
		node_e.setLeftChild(node_h).setRightChild(node_i);

		System.out.println(preOrder(node_a));

		System.out.println(getDeep(node_a));

	}

	/**
	 * @Description:先序便利
	 * @param node
	 * @return
	 * @returType:String
	 */
	public static String preOrder(Node node){
		String prefix = " ";
		if(node.getLeftChild() == null && node.getRightChild() == null){
			return prefix + node.data;
		}

		if(node.getLeftChild() == null){
			return prefix + node.data + preOrder(node.getRightChild());
		}

		if(node.getRightChild() == null){
			return prefix + node.data + preOrder(node.leftChild);
		}

		return prefix + node.data + preOrder(node.leftChild)+preOrder(node.rightChild);
	}

	public static int getDeep(Node node){
		if(node.getLeftChild() == null && node.getRightChild() == null){
			return 1;
		}

		if(node.getLeftChild() == null){
			return 1+getDeep(node.getRightChild());
		}

		if(node.getRightChild() == null){
			return 1+getDeep(node.getLeftChild());
		}

		return getDeep(node.getLeftChild()) > getDeep(node.getRightChild())? getDeep(node.getLeftChild())+1:getDeep(node.getRightChild())+1;
	}

	public static void setInfo(List<String> infos){

	}

}
