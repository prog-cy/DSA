package binarytree;

import java.util.LinkedList;
import java.util.Queue;

//Deleting an element from the binary tree

public class BinaryTreeDeletion {
	
	static class Node{
		
		int data;
		Node left, right;
		
		//constructor
		Node(int data){
			this.data = data;
		}
	}
	
	//method to delete the given node from the Binary Tree
	static void deleteSpecificNode(Node root, int key) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			
			Node temp = q.remove();
			
			if(temp.data == key) {
				
				temp.data = getDeepestRightMostElement(root);
				return;
			}
			
			if(temp.left != null)q.add(temp.left);
			if(temp.right != null)q.add(temp.right);
		}
		
		System.out.println();
		if(q.isEmpty()) {
			System.out.println(key+" is not present in the tree");
		}
		
		
	}
	
	//method to get deepest right most element from the tree
	static int getDeepestRightMostElement(Node root) {
		
		if(root.left == null && root.right == null) {return -1;}
		
		if(root.right.right == null) {
			
			int data = root.right.data;
			root.right = root.left;
			root.left = null;
			return data;
		}
		return getDeepestRightMostElement(root.right);
	}
	
	
	//method to traverse the tree in inorder fashion
	static void inorder(Node root) {
		
		if(root == null) return;
		
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	      
	//main method
	public static void main(String[] args) {
		
		Node root = new Node(10);
	    root.left = new Node(11);
	    root.left.left = new Node(7);
	    root.left.right = new Node(12);
	    root.right = new Node(9);
	    root.right.left = new Node(15);
	    root.right.right = new Node(8);
	    
	    
		System.out.print("Inorder: ");
		inorder(root);
		
		deleteSpecificNode(root, 11);
		
		System.out.print("\nInorder: ");
		inorder(root);
		
	}
}
