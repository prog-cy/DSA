package binarytree;

public class CheckIdentical {
	
	static java.util.Scanner sc = new java.util.Scanner(System.in);
	
	static class Node{
		
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}
	
	//method to create a binary tree
	static Node createBT() {
		
		System.out.println("Enter data: ");
		int data = sc.nextInt();
		
		if(data == -1)return null;
		
		Node node = new Node(data);
		
		System.out.println("Enter left node of: "+node.data);
		node.left = createBT();
		
		System.out.println("Enter right node of: "+node.data);
		node.right = createBT();
		
		return node;
		
	}
	
	//method to traverse a binary tree in preorder
	static void preorder(Node root) {
		
		if(root == null) return;
		
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	//method to check that tree is identical or not
	static boolean isIdentical(Node root1, Node root2) {
		
		if(root1 == null && root2 == null) return true;
		return (root1 != null && root2 != null) && (root1.data == root2.data) && isIdentical(root1.left ,root2.left) && isIdentical(root1.right, root2.right);
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Create first tree: ");
		Node root1 = createBT();
		
		System.out.println("Create second tree: ");
		Node root2 = createBT();
		
		System.out.println("\nElements present in first tree: ");
		preorder(root1);
		
		System.out.println("\nElements present in second tree: ");
		preorder(root2);
		
		if(isIdentical(root1, root2))
			System.out.println("\nTrees are identical");
		else
			System.out.println("\nTrees are not identical");
		
	}

}
