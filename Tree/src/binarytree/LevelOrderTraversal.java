package binarytree;


public class LevelOrderTraversal {
	
	static class Node{
		
		int data;
		Node left, right;
		
		Node(int data){this.data = data;}
	}
	
	static void preorder(Node root) {
		if(root == null) return;
		
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	static void printAtLevel(Node root, int level) {
		
		if(root == null)return;
		
		else if(level == 1) {
			
			System.out.print(root.data+" ");
			return;
		}
		
		printAtLevel(root.left, level - 1);
		printAtLevel(root.right, level - 1);
	}
	
	static int getHeight(Node root) {
		
		if(root == null) return 0;
		
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	//method to traverse a tree in level order
	static void levelOrder(Node root) {
		
		int h = getHeight(root);
		
		for(int i = 1; i<=h; i++)
			printAtLevel(root, i);
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
		
		System.out.print("\nLevel order: ");
		levelOrder(root);
	}

}
