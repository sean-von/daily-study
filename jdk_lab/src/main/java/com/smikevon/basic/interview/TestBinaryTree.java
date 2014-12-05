package com.smikevon.basic.interview;

import java.util.Arrays;

public class TestBinaryTree {

	static class Node{
		private String text;
		private Node lChild;
		private Node rChild;

		public Node(String test) {
			this.text = test;
		}
		public String getText() {
			return text==null?"":text;
		}
		public void setText(String test) {
			this.text = test;
		}
		public Node getlChild() {
			return lChild;
		}
		public void setlChild(Node lChild) {
			this.lChild = lChild;
		}
		public Node getrChild() {
			return rChild;
		}
		public void setrChild(Node rChild) {
			this.rChild = rChild;
		}

	}

	public static void main(String[] args) throws Exception {

		Node node_a = new Node("a");
		Node node_b = new Node("b");
		Node node_c = new Node("c");
		Node node_d = new Node("d");
		Node node_e = new Node("e");
		Node node_f = new Node("f");
		Node node_g = new Node("g");
		Node node_h = new Node("h");
		Node node_i = new Node("i");
		Node node_j = new Node("j");
		Node node_k = new Node("k");
		Node node_l = new Node("l");
		Node node_m = new Node("m");

		node_a.setlChild(node_b);
		node_a.setrChild(node_g);
		node_b.setlChild(node_c);
		node_b.setrChild(node_d);
		node_d.setlChild(node_e);
		node_d.setrChild(node_f);
		node_g.setlChild(node_h);
		node_g.setrChild(node_j);
		node_h.setrChild(node_i);
		node_j.setlChild(node_k);
		node_j.setrChild(node_l);
		node_l.setlChild(node_m);

		rootFirstScan(node_a);

		System.out.println();


		rootMiddleScan(node_a);

		System.out.println();


		rootLastScan(node_a);

		System.out.println();
		System.out.print("找到的最小祖先是:");
		System.out.println(findCommonAncestor(node_a,"i","f").getText());

		String middleChars = "cbedfahigkjml";
		String lastChars = "cefdbihkmljga";

		System.out.println("开始构建二叉树:");
		Node node = makeBinaryTree(middleChars.toCharArray(), lastChars.toCharArray());

		rootFirstScan(node);
	}

	/**
	 * @Description:先序遍历二叉树 a b c d e f g h i j k l m
	 * @param root
	 * @returType:void
	 */
	public static void rootFirstScan(Node root){
		if(root == null){
			return;
		}

		System.out.print(root.getText());

		if (root.getlChild() != null) {
			rootFirstScan(root.getlChild());
		}

		if(root.getrChild() != null){
			rootFirstScan(root.getrChild());
		}

	}

	/**
	 * @Description:中序遍历二叉树 c b e d f a h i g k j m l
	 * @param root
	 * @returType:void
	 */
	public static void rootMiddleScan(Node root){

		if(root == null){
			return;
		}

		if (root.getlChild() != null) {
			rootMiddleScan(root.getlChild());
		}

		System.out.print(root.getText());

		if(root.getrChild() != null){
			rootMiddleScan(root.getrChild());
		}

	}

	/**
	 * @Description:后序遍历二叉树 c e f d b i h k m l j g a
	 * @param root
	 * @returType:void
	 */
	public static void rootLastScan(Node root){
		if(root == null){
			return;
		}

		if (root.getlChild() != null) {
			rootLastScan(root.getlChild());
		}

		if(root.getrChild() != null){
			rootLastScan(root.getrChild());
		}

		System.out.print(root.getText());
	}

	/**
	 * @Description:给出中序和后序遍历，求出二叉树
	 * @param middleChars
	 * @param lastChars
	 * @throws Exception
	 * @returType:void
	 */
	public static Node makeBinaryTree(char[] middleChars , char[] lastChars) throws Exception{
		int middleLength = middleChars.length;
		int lastLength = lastChars.length;

		if(middleLength != lastLength){
			throw new Exception("长度应该一致");
		}

		if(middleLength == 0){//说明子节点为null
			return null;
		}

		if (middleLength == 1) {//构建叶子节点
			return new Node(middleChars[0]+"");
		}

		Node root = new Node(lastChars[lastLength-1]+"");

		int pos = -1;
		for(int i=0;i<middleLength;i++){//找到父节点，在中序遍历里的位置
			if(middleChars[i] == lastChars[lastLength-1]){
				pos = i;
			}
		}

		root.setlChild(makeBinaryTree(Arrays.copyOfRange(middleChars, 0, pos),Arrays.copyOfRange(lastChars, 0, pos)));
		root.setrChild(makeBinaryTree(Arrays.copyOfRange(middleChars, pos+1, middleLength),Arrays.copyOfRange(lastChars, pos, lastLength-1)));//注意最后一个参数，和左子树构建的不一致
		return root;
	}

	/**
	 * @Description:找到两个节点的公共父节点
	 * @param node
	 * @param value1
	 * @param value2
	 * @return
	 * @returType:Node
	 */
	public static Node findCommonAncestor(Node node,String value1,String value2 ){
		if(node == null){
			return null;
		}
		if(node.getText().equals(value1) || node.getText().equals(value2)){
			return node;
		}
		Node node1 = findCommonAncestor(node.getlChild(), value1, value2);
		Node node2 = findCommonAncestor(node.getrChild(), value1, value2);
		if(node1==null){//左子树没有找到任何一个结点，则第一个公共父节点必定在右子树，而且找到第一个结点就是最低共同父节点
			return node2;
		}else if(node2 == null){//右子树没有找到任何一个结点，则第一个公共父节点必定在左子树，而且找到第一个结点就是最低共同父节点
			return node1;
		}else{//分别在结点的左右子树找到，则此节点必为第一个公共父节点
			return node;
		}
	}

}
