package binarytree;

import java.util.*;

//Creating a binary tree having n-nodes

public class BinaryTreeDemo2 {
	
	
	Scanner sc = new Scanner(System.in);
	
	class Node{
		
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
		}
	}
	
	//creating in binary tree
	Node createNode() {
		
		System.out.println("Enter data: ");
		int val = sc.nextInt();
		
		
		if(val == -1) return null;
		
		Node node = new Node(val);
		
		System.out.println("Enter Left node of "+node.data);
		node.left = createNode();
		System.out.println("Enter Right node of "+node.data);
		node.right = createNode();
		return node;
		
	}
	
	//preorder traversal
	void preorder(Node root) {
		
		if(root == null)return;
		
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	//main method
	public static void main(String[] args) {
		BinaryTreeDemo2 tree = new BinaryTreeDemo2();
		
		Node root = tree.createNode();
		
		System.out.println("\nPreorder of tree element: ");
		tree.preorder(root);
	}
	
}
