package binarytree;

import binarytree.SumOfNodes.Node; //In this line I have imported the Node class from previous class

//In this problem we will get the difference of nodes at even and odd levels

public class DifferenceOfNodesAtEvenOddLevel {

	//method to get the sum of odd and even nodes of a binary tree
	static int getDifferenceOfEvenOdd(Node root) {
		
		if(root == null)return 0;
		
		return root.data - getDifferenceOfEvenOdd(root.left) - getDifferenceOfEvenOdd(root.right);
	}
	

	//main method
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		System.out.print("Preorder: ");
		SumOfNodes.preoreder(root);
		
		System.out.println("\nDifference of sum of even and odd level nodes of a tree: "+getDifferenceOfEvenOdd(root));
		
	}

}
