package com.smikevon.algorithm.greedySelector;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 霍夫曼编码，贪心算法的一种
 * 				 时间复杂度为O（nlogn）
 * @author     : fengxiao
 * @date       : 2014年7月24日 下午3:52:24
 */
public class HuffmanTree {


	public static void main(String[] args) {
		Integer[] f = {45,13,12,16,9,5};
		List<Node> nodes = new LinkedList<Node>();
		//构造树结构基本节点
		for(int tmp : f){
			nodes.add(new Node(tmp));
		}
		//递归获取根节点
		Node root = makeTree(nodes);

		//递归打印出霍夫曼编码
		show(root,"");
	}

	/**
	 * @Description:霍夫曼算法构建最优二叉树，递归构建
	 * @param nodes
	 * @return
	 * @returType:Node
	 */
	public static Node makeTree(List<Node> nodes){
		if( nodes.size() == 1 ){
			return nodes.get(0);
		}
		Collections.sort(nodes);
		System.out.println(nodes);
		Node tmpNode = new Node(nodes.get(0).getValue() + nodes.get(1).getValue());
		tmpNode.setLeftNode(nodes.get(0));
		tmpNode.setRightNode(nodes.get(1));
		nodes.remove(0);
		nodes.remove(0);
		nodes.add(tmpNode);
		return makeTree(nodes);
	}

	/**
	 * @Description:递归打印霍夫曼树
	 * @param root
	 * @param prepend
	 * @returType:void
	 */
	public static void show(Node root,String prepend){

		if (root.getLeftNode()!=null) {
			show(root.getLeftNode(),prepend+"0");
		}

		if(root.getRightNode() !=null){
			show(root.getRightNode(),prepend+"1");
		}

		if(root.getLeftNode() == null && root.getRightNode() == null){
			System.out.println(root.getValue()+":"+prepend);
		}

	}

}

class Node implements Comparable<Node>{
	int weight ;
	int value ;
	Node leftNode;
	Node rightNode;
	public Node(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}

	public Node(int value) {
		this.value = value;
	}

	public int getWeight() {

		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getValue() {

		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getLeftNode() {

		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public Node getRightNode() {

		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	public int compareTo(Node o) {
		return o.getValue()>this.getValue()? -1 : o.getValue()==this.getValue()? 0 : 1;
	}

	@Override
	public String toString() {
		return "Node [ value=" + value +  "]";
	}


}
