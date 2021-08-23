package binarytree;


//In this program I will convert a tree to its sum tree
//Every node is the sum of its left and right subtree

public class ConvertInSumTree {
	
	static class Node{
		
		int data;
		Node left, right;
		Node(int data){this.data = data;}
	}
	
	static int sumTree(Node root) {
		
		if(root == null) return 0;
	
		int left = sumTree(root.left);
		int right = sumTree(root.right);
		
		int old = root.data;
		
		root.data = left + right;
		
		return root.data + old;
	}
	
	static void preorder(Node root) {
		if(root == null) return;
		
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		System.out.print("Preorder: ");
		preorder(root);
		
		sumTree(root);
		System.out.print("\nPreorder: ");
		preorder(root);
		
	}

}
