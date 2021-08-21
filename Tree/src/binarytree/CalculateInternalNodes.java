package binarytree;

public class CalculateInternalNodes {
	
	static class Node{
		
		int data;
		Node left, right;
		Node(int data){this.data = data;}
	}
	
	//method to traverse the tree in preorder
	static void preorder(Node root) {
		
		if(root == null) return;
		
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	static int getTotalNumberOfNodes(Node root) {
		
		if(root == null) return 0;
		
		return 1 + getTotalNumberOfNodes(root.left) + getTotalNumberOfNodes(root.right);
	}
	
	static int getTotalNumberOfLeafNodes(Node root) {
		
		if(root == null) return 0;
		
		else if(root.left == null && root.right == null) return 1;
		
		return getTotalNumberOfLeafNodes(root.left) + getTotalNumberOfLeafNodes(root.right);
	}
	
	//method to get total number of internal nodes in tree
	static int getInternalNodes(Node root) {
		
		return getTotalNumberOfNodes(root) - getTotalNumberOfLeafNodes(root);
	}
	
	//main method
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
		
		System.out.println("\nTotal number of internal nodes in this tree: "+getInternalNodes(root));
	}
}
