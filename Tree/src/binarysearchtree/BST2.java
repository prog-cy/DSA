package binarysearchtree;

//Deletion in Binary Search Tree


public class BST2 {
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
	
	static void levelOrder(Node root) {
		
		if(root == null)return;
		java.util.Queue<Node> q = new java.util.LinkedList<>();
		
		q.add(root);
		
		while(q.size()>0) {
			
			Node temp = q.remove();
			
			System.out.print(temp.data+" ");
			
			if(temp.left != null)q.add(temp.left);
			if(temp.right != null)q.add(temp.right);
		}
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
		
		System.out.println("\nLevel Order of BST: ");
		levelOrder(root);
	
	}
}
