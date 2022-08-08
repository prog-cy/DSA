package binarysearchtree;

public class BST1 {
	
	//Node of the Binary Tree
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
	
	//method to insert data in BST
	static void insert(int data) {
		
		root = insert(root, data);
	}

	static Node insert(Node root, int data) {
		
		if(root == null) 
			root = new Node(data);
			
		else if(data < root.data) 
			root.left = insert(root.left, data);
		
		else
			root.right = insert(root.right, data);
		
		return root;
	}
	
	
	//method to search an element in BST
	static boolean search(int key) {
		
		return search(root, key);
	}
	
	static boolean search(Node root, int key) {
		
		if(root == null) return false;
		else if(root.data == key) return true;
		else if(key < root.data) return search(root.left, key);
		else return search(root.right, key);
		
	}
	
	//In order traversal
	static void inorder(Node root) {
		
		if(root == null) return;
		
		inorder(root.left);
		
		System.out.print(root.data+" ");
		
		inorder(root.right);
	}
	
	//method to get the minimum value in the BST
	static int getMin(Node root) {
		
		if(root.left == null) return root.data;
		return getMin(root.left);
	}
	
	//method to get the maximum value in the BST
	static int getMax(Node root) {
		
		if(root.right == null) return root.data;
		return getMax(root.right);
	}
	
	//method to get sum of all the nodes
	static int getTotalSum(Node root) {
		
		if(root == null) return 0;
		return root.data + getTotalSum(root.left) + getTotalSum(root.right);
	}
	
	//method to count total number of nodes in the tree
	static int countTotalNode(Node root) {
		
		if(root == null) return 0;
		return 1 + countTotalNode(root.left) + countTotalNode(root.right);
	}
	
	//method to get the height of the tree
	static int getHeight(Node root) {
		
		if(root == null) return -1;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	//method to count total number of leaf nodes in the tree
	static int countLeaf(Node root) {
		if(root == null) return 0;
		else if(root.left == null && root.right == null)return 1;
		
		return countLeaf(root.left) + countLeaf(root.right );
	}
	
	//this method is used to print nodes at any level
	static void printNodesAtLevel(Node root, int level) {
		
		if(root == null) return;
		
		else if(level == 0) {
			System.out.print(root.data+" ");
			return;
		}
		printNodesAtLevel(root.left, level - 1);
		printNodesAtLevel(root.right, level - 1);
	}
	
	//method to traverse a tree in level order
	static void levelorder(Node root) {
		
		int h = getHeight(root);
		
		for(int i = 0; i<=h; i++) {

			printNodesAtLevel(root, i);
			System.out.println();
		}
	}
	//main method
	public static void main(String[] args) {
		
		insert(15);
		insert(5);
		insert(10);
		insert(25);
		insert(7);
		insert(90);
		insert(12);
		insert(78);
		insert(120);
		
		System.out.print("Inorder: ");
		inorder(root);
		
		System.out.println("\nLevel order: ");
		levelorder(root);
		
		System.out.println();
		if(search(90))
			System.out.println(90+" is present");
		else
			System.out.println("Not present");
		
		System.out.println("Minimum value in tree: "+getMin(root));
		System.out.println("Maximum value in tree: "+getMax(root));
		System.out.println("Sum of all the nodes in the tree: "+getTotalSum(root));
		System.out.println("Total number of nodes in the tree: "+countTotalNode(root));
		System.out.println("Total number of leaf nodes in the tree: "+countLeaf(root));
		System.out.println("Height of the tree: "+getHeight(root));
	}

}
