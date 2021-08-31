package binarytree;
import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

//Insertion in binary tree at first place in level order 

public class BinaryTreeInsertion {
	
	static class Node{
		
		int data;
		Node left, right;
		Node(int data){this.data = data;}
	}
	
	//method to insert data in the tree 
	static void insertNode(Node root, int data) {
		
		Queue<Node> q = new LinkedList<>();
		
		q.add(root);
		
		while(!q.isEmpty()) {
			
			Node temp = q.remove();
			
			if(temp.left == null) {
				
				temp.left = new Node(data);
				return;
			}
			else
				q.add(temp.left);
			
			if(temp.right == null) {
				temp.right = new Node(data);
				return;
			}
			else
				q.add(temp.right);
		}
	}
	
	//method to traverse the tree in level order
	static void levelOrder(Node root) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			
			Node temp = q.remove();
			
			System.out.print(temp.data+" ");
			if(temp.left != null)q.add(temp.left);
			if(temp.right != null) q.add(temp.right);
			
		}
	}
	
	//method to get the deepest right most element in the binary tree
	static int getDeepestRightMostElement(Node root) {
		
		if(root.right == null) return root.data;
		return getDeepestRightMostElement(root.right);
	}
	
	//method to get the deepest left most element in the binary tree
	static int getDeepestLeftMostElement(Node root) {
		
		if(root.left == null) return root.data;
		return getDeepestLeftMostElement(root.left);
	}
	
	//main method
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(60);
		root.right.left = new Node(50);
		
		System.out.print("Level order: ");
		levelOrder(root);
		
		System.out.println("\nEnter data which you want to insert in the tree: ");
		int data = Integer.parseInt(br.readLine());
		insertNode(root, data);
		
		System.out.print("\nLevel order: ");
		levelOrder(root);
		
		System.out.println("\nDeepest right most element in the Tree: "+getDeepestRightMostElement(root));
		System.out.println("Deepest left most element in the Tree: "+getDeepestLeftMostElement(root));
		
	}

}
