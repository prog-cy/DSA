package binarytree;

//creating a binary tree having 5 nodes

public class BinaryTreeDemo1 {
	
	//Creating node of the binary tree
	class Node{
		
		int data;
		Node left, right;
		
		Node(int data){
			this.data = data;
			left = null;
			right = null;
			
		}
	}
	
	//main method
	public static void main(String[] args) {
		
		BinaryTreeDemo1 tree = new BinaryTreeDemo1();
		
		Node root = null;
		
		Node node1 = tree.new Node(1);
		root = node1;
		
		Node node2 = tree.new Node(2);
		root.left = node2;
		
		Node node3 = tree.new Node(3);
		root.right = node3;
		
		Node node4 = tree.new Node(4);
		root.left.left = node4;
		
		Node node5 = tree.new Node(5);
		root.right.right = node5;
		
		System.out.println("Tree elements displayed in preorder");
		tree.preorder(root);
		
		System.out.println("\nTree elements displayed in inoreder");
		tree.inorder(root);
		
		System.out.println("\nTree elements displayed in postorder");
		tree.postorder(root);
	}
	
	//preorder traversal
	void preorder(Node temp) {
		
		if(temp == null)return;
		
		System.out.print(temp.data+" ");
		
		preorder(temp.left);
		
		preorder(temp.right);
	
	}
	
	//inorder traversal
	void inorder(Node temp) {
		
		if(temp == null)return;
		
		inorder(temp.left);
		
		System.out.print(temp.data+" ");
		
		inorder(temp.right);
		
	}
	
	//post order traversal
	void postorder(Node temp) {
		
		if(temp == null)return;
	
		postorder(temp.left);
		
		postorder(temp.right);
		
		System.out.print(temp.data+" ");
	}
}
