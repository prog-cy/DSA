package binarysearchtree;

import java.util.ArrayList;

public class IterativeInsertion {
	
	static class Node{
		
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
		}
	}
	
	//Iterative insertion in BST
	static Node insert(Node root, int data) {
		
		Node curr = root;
		Node parent = null; //This node to hold the previous value so that we can link it with new node;
		
		while(curr != null) {
			
			parent = curr;
			
			if(curr.data < data)
				curr = curr.right;
			else if(curr.data > data)
				curr = curr.left;
			else
				return root;
		}
		
		if(parent == null) //When tree is empty
			root = new Node(data);
		else if(parent.data < data)
			parent.right = new Node(data);
		else
			parent.left = new Node(data);
		
		
		return root;
	}
	
	//In order traversal
	static ArrayList<Integer> ans = new ArrayList<>();
	static ArrayList<Integer> preOrder(Node root) {
		
		if(root == null) return null;
		
		ans.add(root.data);
		preOrder(root.left);
		preOrder(root.right);
		
		return ans;
	}
	
	//In order
	static ArrayList<Integer> ans1 = new ArrayList<>();
	static ArrayList<Integer> inOrder(Node root) {
		
		if(root == null) return null;
		
		inOrder(root.left);
		ans1.add(root.data);
		inOrder(root.right);
		
		return ans1;
	}
	
	//main method
	public static void main(String[] args) {
		
		Node root = null;
		root = insert(root, 10);
		root = insert(root, 20);
		root = insert(root, 9);
		root = insert(root, 7);
		root = insert(root, 5);
		root = insert(root, 8);
		root = insert(root, 56);
		
		System.out.println("Pre order: "+preOrder(root));
		System.out.println("In order: "+inOrder(root));
	}

}
