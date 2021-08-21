package binarytree;


public class CountTotalNumberOfLeafNodes {
	
	static class Node{
		int data;
		Node left, right;
		
		Node(int data){this.data = data;}
	}
	
	//method to count total number of leaf nodes in a binary tree
	static int getTotalNumberOfLeaf(Node root) {
		
		if(root == null) return 0;
		
		else if(root.left == null && root.right == null)return 1;
		
		return getTotalNumberOfLeaf(root.left) + getTotalNumberOfLeaf(root.right);
	}
	
	//method to print the tree 
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
		
		System.out.println("\nTotal number of leaf nodes in this tree: "+getTotalNumberOfLeaf(root));
		
	}

}
