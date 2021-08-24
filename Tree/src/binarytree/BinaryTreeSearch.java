package binarytree;


public class BinaryTreeSearch {
	
	static class Node{
		
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
		}
	}
	
	//method to search the element in binary tree
	static boolean isPresent = false;
	static boolean search(Node root, int key) {
		
		if(root == null) return false;
		else if(root.data == key)isPresent = true;
		search(root.left, key);
		search(root.right, key);
		return isPresent;
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(10);
		root.left = new Node(20);
		root.left.left = new Node(30);
		root.left.right = new Node(45);
		root.right = new Node(11);
		root.right.left = new Node(22);
		root.right.right = new Node(33);
		
		System.out.println(search(root, 22));
		
	}

}
