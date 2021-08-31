package binarytree;
import java.util.*;

//In this class we will implement a tree using array

public class ArrayImplementaionOfTree {
	
	static ArrayList<Integer> tree = new ArrayList<>();
	
	//preorder traversal
	static void preorder(int index) {
		
		if(index >= tree.size()) return;
		
		System.out.print(tree.get(index)+" ");
		preorder((2*index) + 1);
		preorder((2*index) + 2);
	}
	
	//inorder traversal
	static void inorder(int index) {
		
		if(index >= tree.size()) return;
		
		inorder((2*index) + 1);
		System.out.print(tree.get(index) + " ");
		inorder((2*index) + 2);
	}
	
	//postorder traversal
	static void postorder(int index) {
		
		if(index >= tree.size()) return;
		
		postorder((2*index) + 1);
		postorder((2*index) + 2);
		System.out.print(tree.get(index) +" ");
	}
	
	//level order traversal
	static void levelorder(int index) {
		
		for(;index<tree.size(); index++)
			System.out.print(tree.get(index)+" ");
	}
	
	
	//main method
	public static void main(String[] args) {
		
		tree.add(0, 10);
		tree.add(1, 20);
		tree.add(2, 30);
		tree.add(3, 40);
		tree.add(4, 50);
		tree.add(5, 70);
		tree.add(6, 80);
		
		System.out.print("Preorder: ");
		preorder(0);
		
		System.out.print("\nInorder: ");
		inorder(0);
		
		System.out.print("\nPostorder: ");
		postorder(0);
		
		System.out.print("\nLevel order: ");
		levelorder(0);
		
	}

}
