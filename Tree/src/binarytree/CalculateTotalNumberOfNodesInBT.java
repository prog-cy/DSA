package binarytree;

//In this problem we will calculate total number of nodes in BT

import binarytree.BinaryTreeDemo1.Node; //In this line I have imported Node class 

public class CalculateTotalNumberOfNodesInBT {
	
	//method to calculate the total nuber of nodes present in binary tree
	static int getTotalNodes(Node root) {
		
		if(root == null) return 0;
		
		return 1 + getTotalNodes(root.left) + getTotalNodes(root.right);
		
	}
	
	//another implementation of above method
	static int count = 0;
	static int countNodes(Node root) {
		if(root == null) return 0;
		
		countNodes(root.left);
		countNodes(root.right);
		
		count += 1;
		
		return count;
	}
	
	//main method
	public static void main(String[] args) {
		
		BinaryTreeDemo1 tree = new BinaryTreeDemo1();
		
		Node root = tree.new Node(10);
		root.left = tree.new Node(20);
		root.left.left = tree.new Node(30);
		root.left.right = tree.new Node(45);
		root.right = tree.new Node(11);
		root.right.left = tree.new Node(22);
		root.right.right = tree.new Node(33);
		
		System.out.print("Preorder: ");
		tree.preorder(root);
		
		System.out.println("\nTotal number of nodes in this tree: "+getTotalNodes(root));
		System.out.println("Total number of nodes in this tree: "+countNodes(root));
	}

	
}
