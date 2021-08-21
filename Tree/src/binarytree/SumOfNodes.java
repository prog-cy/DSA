package binarytree;

// In this program we will find the sum of all nodes of a binary tree

public class SumOfNodes {
	
	static class Node{
		
		int data;
		Node left, right;
		Node(int data){this.data = data;}
	}
	
	//method to traverse the binary try
	static void preoreder(Node root) {
		if(root == null) return;
		
		System.out.print(root.data+" ");
		preoreder(root.left);
		preoreder(root.right);
	}
	
	//method to calculate the sum of the binary tree 
	static int getSum(Node root) {
		
		if(root == null)return 0;
		return root.data + getSum(root.left) + getSum(root.right);
	}
	//main method
	public static void main(String[] args) {
		
		Node root = new Node(10);
		root.left = new Node(20);
		root.left.left = new Node(30);
		root.left.right = new Node(45);
		root.right = new Node(11);
		root.right.left = new Node(22);
		root.right.right = new Node(33);
		
		System.out.print("Preorder: ");
		preoreder(root);
		
		System.out.println("\nSum of tree is: "+getSum(root));
	}
}
