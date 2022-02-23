package binarytree;


public class GetHeightOfTree {
	
	static class Node{
		
		int data;
		Node left, right;
		Node(int data){this.data = data;}
	}
	
	//method to print the tree in preorder
	static void preorder(Node root) {
		
		if(root == null) return;
		
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	//method to calculate the height of the tree
	static int getHeight(Node root) {
		
		if(root == null) return -1;
		
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
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
		
		System.out.println("\nHeight of this tree: "+getHeight(root));
	}

	
	
}
