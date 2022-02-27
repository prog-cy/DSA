package treetraversal;

import java.util.Stack;

//implementing iterative DFS traversal 


public class IterativeDFSTraversal {
	
	static Stack<Node<Integer>> stack = new Stack<>();
	 
	//method to implement preorder traversal iteratively
	static void preorder(Node<Integer> root) {
		
		if(root == null)return;
		
		stack.push(root);
		
		while(!stack.empty()) {
			
			Node<Integer> current = stack.pop();
			
			System.out.print(current.data+" ");
			if(current.right != null)stack.push(current.right);
			if(current.left != null)stack.push(current.left);
			
			
		}
	}
	
	//method to implement postorder traversal 
	static void postorder(Node<Integer> root) {
		
		if(root == null) return;
		
		Node<Integer> q, temp;
		q = temp = root;
		
		while(true) {
			
			while(temp.left != null) {
				stack.push(temp);
				temp = temp.left;
			}
			
			while(temp.right == null || temp.right == q) {
				System.out.print(temp.data+" ");
				q = temp;
				if(stack.empty())return;
				temp = stack.pop();
			}
			
		 stack.push(temp);
		 temp = temp.right;
		}
	}
	
	//method to implement inorder
	static void inorder(Node<Integer> root) {
		
		if(root == null)return;
		
		Node<Integer> temp = root;
		
		while(true) {
			
			while(temp.left != null) {
				stack.push(temp);
				temp = temp.left;
			}
			
			while(temp.right == null) {
				System.out.print(temp.data+" ");
				if(stack.empty())
					return;
				temp = stack.pop();
			}
			System.out.print(temp.data+" ");
			temp = temp.right;
		}
		
		
	}
	
	//main method
	public static void main(String[] args) {
		
		Node<Integer> root = new Node<>(1);
		root.left = new Node<>(2);
		root.right = new Node<>(3);
		root.left.left = new Node<>(4);
		root.left.left.left = new Node<>(10);
		root.left.right = new Node<>(5);
		root.right.left = new Node<>(6);
		root.right.right = new Node<>(7);
		root.right.right.left = new Node<>(8);
		
		System.out.print("Preorder: ");
		preorder(root);
		
		System.out.print("\nPostorder: ");
		postorder(root);
		
		System.out.print("\nInorder: ");
		inorder(root);
	}

}
