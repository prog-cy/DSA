package binarytree;
import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

//Insertion in binary tree at first place in level order 

public class BinaryTreeInsertion {
	
	static class Node{
		
		int data;
		Node left, rigth;
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
			
			if(temp.rigth == null) {
				temp.rigth = new Node(data);
				return;
			}
			else
				q.add(temp.rigth);
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
			if(temp.rigth != null) q.add(temp.rigth);
			
		}
	}
	
	//main method
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Node root = new Node(10);
		root.left = new Node(20);
		root.rigth = new Node(30);
		root.left.left = new Node(40);
		root.left.rigth = new Node(60);
		root.rigth.left = new Node(50);
		
		System.out.print("Level order: ");
		levelOrder(root);
		
		System.out.println("\nEnter data which you want to insert in the tree: ");
		int data = Integer.parseInt(br.readLine());
		insertNode(root, data);
		
		System.out.print("\nLevel order: ");
		levelOrder(root);
			
	}

}
