package treetraversal;

import java.util.LinkedList;
import java.util.Queue;

//Iterative implementation of level order traversal
// Level order traversal is a type of BFS (Breadth first search) traversal

public class IterativeLevelOrderTraversal2 {
	
	//method for traversing a tree in level order
	static void levelOrder(Node<Integer> root) {
		
		Queue<Node<Integer>> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			
			Node<Integer> current = q.peek();
			
			System.out.print(current.data+" ");
			if(current.left != null) q.add(current.left);
			if(current.right != null) q.add(current.right);
			q.remove();
		}
		
	}
	
	//main method
	public static void main(String[] args) {
		
		Node<Integer> root = new Node<>(1);
		root.left = new Node<>(2);
		root.left.left = new Node<>(4);
		root.left.right = new Node<>(5);
		root.right = new Node<>(3);
		root.right.left = new Node<>(6);
		root.right.right = new Node<>(7);
		root.right.right.left = new Node<>(10);
		
		System.out.print("Level order: ");
		levelOrder(root);
		
	}

}
