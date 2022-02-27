package treetraversal;

import java.util.*;

public class IterativeInorderTraversal {
	
	static void inorder(Node<Integer> root) {
		
		if(root == null)return;
		
		Stack<Node<Integer>> stack = new Stack<>();
		
		Node<Integer> temp = root;
		
		while(stack.size() > 0 || temp != null) {
			
			if(temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			
			else {
				temp = stack.pop();
			
				System.out.print(temp.data+" ");
			
				temp = temp.right;
			}
		}
	}
	
	public static void main(String[] args) {
		
		Node<Integer> root = new Node<>(1);
		root.left = new Node<>(2);
		root.left.left = new Node<>(4);
		root.left.right = new Node<>(5);
		root.right = new Node<>(3);
		root.right.left = new Node<>(6);
		root.right.right = new Node<>(7);
		root.right.right.left = new Node<>(10);
		
		System.out.println("Inorder Traversal : ");
		inorder(root);
		
	}

}
