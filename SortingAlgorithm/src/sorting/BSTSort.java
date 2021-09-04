package sorting;

import java.util.Arrays;
import java.util.Stack;

public class BSTSort {
	
	static class Node{
		
		int data;
		Node left, right;
		Node(int data){this.data = data;}
	}
	
	//method to insert data in Binary Search Tree
	static Node insert(Node root, int data) {
		
		if(root == null)
			root = new Node(data);
		
		else if(data <= root.data)
			root.left = insert(root.left, data);
		else
			root.right = insert(root.right, data);
		
		return root;
	}
	
	//method of BST sort
	static void bstSort(Node root, int[] arr) {
		
		Stack<Node> stack = new Stack<>();
		Node temp = root;
		int i = 0;
		while(true) {
			
			while(temp.left != null) {
				stack.push(temp);
				temp = temp.left;
			}
			
			while(temp.right == null) {
				
				arr[i++] = temp.data;
				if(stack.empty())
					return;
				temp = stack.pop();
			}
			
			arr[i++] = temp.data;
			temp = temp.right;
		}
	}
	
	//main method
	public static void main(String[] args) {
		
		int[] arr = {10, 5, 6, 20, 24, 78, 90, 12, 1, 23};
		
		System.out.println("Array before sorting: "+Arrays.toString(arr));
		
		Node root = null;
		
		for(int i = 1; i<arr.length; i++) 
			root = insert(root, arr[i]);
		
		
		bstSort(root, arr);
		
		System.out.println("Array after sorting: "+Arrays.toString(arr));
		
	}

}
