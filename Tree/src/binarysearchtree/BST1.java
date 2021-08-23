package binarysearchtree;

public class BST1 {
	
	static class Node{
		
		int data;
		Node left, right;
		
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}
	
	//method to insert in BST 
	static Node insert(Node root, int data) {
		
		if(root == null) 
			root = new Node(data);
			
		else if(data <= root.data) 
			root.left = insert(root.left, data);
		
		else
			root.right = insert(root.right, data);
		
		return root;
	}
	
	//method to search an element in BST
	static boolean search(Node root, int key) {
		
		if(root == null) return false;
		else if(root.data == key) return true;
		else if(key <= root.data) return search(root.left, key);
		else return search(root.right, key);
		
	}
	
	//Inorder traversal
	static void inorder(Node root) {
		
		if(root == null) return;
		
		inorder(root.left);
		
		System.out.print(root.data+" ");
		
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		
		Node root = insert(null, 15);
		insert(root, 5);
		insert(root, 10);
		insert(root, 25);
		insert(root, 7);
		insert(root, 90);
		insert(root, 12);
		insert(root, 78);
		
		
		inorder(root);
		
		System.out.println();
		
		if(search(root, 90))
			System.out.println("present");
		else
			System.out.println("Not present");
	}

}
