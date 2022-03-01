package binarysearchtree;

//Deletion in Binary Search Tree


public class BST2 {
	
	//Creating Node of binary tree.
	static class Node{
		
		int data;
		Node left, right;
		Node(int data){
			
			this.data = data;
			left = right = null;
		}
	}
	
	
	static Node root;
	
	static {root = null;}
	
	//Inserting data into binary tree
	static void insert(int data) {
		
		root = insert(root, data);
	}
	
	static Node insert(Node root, int data) {
		
		if(root == null)
			root = new Node(data);
		else if(root.data < data)
			root.right = insert(root.right, data);
		else
			root.left = insert(root.left, data);
		return root;
	}
	
	//Inorder traversal which prints the BST in ascending order
	static void inorder(Node root) {
		
		if(root == null)return;
		java.util.Stack<Node> stack = new java.util.Stack<>();
		
		Node temp = root;
		
		while(stack.size()>0 || temp != null) {
			
			if(temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			else {
				
				temp = stack.pop();
				
				System.out.print(temp.data+" ");
				
				temp = temp.right;
			}
		}
	}
	
	//Deletion in BST
	static void delete(int key) {
		
		root = delete(root, key);
	}
	
	static Node delete(Node root, int key) {
		
		if(root == null)return null;
		
		else if(root.data < key)
			root.right = delete(root.right, key);
		else if(root.data > key)
			root.left = delete(root.left, key);
		else {
			
			//Case-1: The node which we are deleting has no child
			if(root.left == null && root.right == null)
				root = null;
			
			//Case-2: The node which we are deleting has one child
			else if(root.left != null)
				root = root.left;
			else if(root.right != null)
				root = root.right;
			//Case-3 The node which we are deleting has two child
			else {
				
				root.data = findMin(root.right);
				
				root.right = delete(root.right, root.data);
			}
		}
		
		return root;
		
	}
	
	//Method to find Minimum Case-3 in deletion
	static int findMin(Node root) {
		
		int min = root.data;
		
		while(root.left != null) {
			min = root.left.data;
			root = root.left;
		}
		
		return min;
		
	}
	
	public static void main(String[] args) {
		
		insert(10);
		insert(5);
		insert(30);
		insert(7);
		insert(40);
		insert(50);
		insert(45);
		insert(12);
		
		System.out.println("Ascending order of BST: ");
		inorder(root);
		
		delete(5);
		
		System.out.println("\nAfter deleting 5 from BST: ");
		inorder(root);
		
		delete(50);
		System.out.println("\nAfter deleting 50 from BST: ");
		inorder(root);
	
	}
}
