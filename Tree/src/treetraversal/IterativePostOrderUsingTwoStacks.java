package treetraversal;
import java.util.*;

//Implementation of post order using two stacks;

public class IterativePostOrderUsingTwoStacks {
	
	static void iterativePostorder(Node<Integer> root) {
		
		Stack<Node<Integer>> s1 = new Stack<>();
		Stack<Node<Integer>> s2 = new Stack<>();
		
		s1.push(root);
		
		while(s1.size()>0) {
			
			Node<Integer> temp = s1.pop();
			
			if(temp.left != null)
				s1.push(temp.left);
			if(temp.right != null)
				s1.push(temp.right);
			
			s2.push(temp);
		}
		
		while(s2.size()>0) {
			
			System.out.print(s2.pop().data+" ");
		}
	}
	
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
		
		iterativePostorder(root);
	}
}
