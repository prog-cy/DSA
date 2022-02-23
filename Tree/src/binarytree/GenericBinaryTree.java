package binarytree;


class Node<T>{
	
	T data;
	
	Node<T> left, right;
	
	Node(T data){this.data = data;}
}

class BinaryTree<T> extends Node<T>{
	
	//this is constructor which calls the Node<T> class constructor 
	BinaryTree(T data){
		super(data);
	}
	
	BinaryTree() {
		this(null);
	}
	
	 static java.util.Scanner sc = new java.util.Scanner(System.in);
	 
	 boolean isInteger(String s) {
		 
		 boolean check = false;
		 
		 for(int i = 0; i<s.length(); i++) {
			 
			 Character ch = s.charAt(i);
			 
			 if(Character.isDigit(ch))
				 check = true;
		 }
		 
		 return check;
	 }
	 
	 
	 Integer getInput(String str) {
		 
		 if(isInteger(str))
			 return Integer.parseInt(str); 
		 else
			 return 0;
	 }
	 
	
	 //method to create a binary tree
	 @SuppressWarnings("unchecked")
	 Node<T> createBT() {
		
		System.out.println("Enter data: ");
		
		String str = sc.next();
		
		T data = (T) getInput(str);
		
		if((Integer)data == -1)return null;
		
		Node<T> node = new BinaryTree<>(data);
		
		System.out.println("Enter left node of "+node.data);
		node.left = createBT();
		
		System.out.println("Enter right node of "+node.data);
		node.right = createBT();
		
		return node;
	}
	 
	//Declaring a stack
	 java.util.Stack<Node<T>> stack = new java.util.Stack<Node<T>>();
	 
	//method to traverse the tree in preorder
	 void preorder(Node<T> root) {
		 
		stack.push(root);
		
		while(!stack.empty()) {
			
			Node<T> current = stack.pop();
			
			System.out.print(current.data+" ");
			
			if(current.right != null)stack.push(current.right);
			if(current.left != null)stack.push(current.left);
			
		}
	 }
	 
	 //method to traverse the tree in Inorder
	 void inorder(Node<T> root) {
		 
		 Node<T> temp = root;
		 
		 while(true) {
			 
			 while(temp.left != null) {
				 stack.push(temp);
				 temp = temp.left;
			 }
			 
			 while(temp.right == null) {
				 
				 System.out.print(temp.data+" ");
				 if(stack.empty())return;
				 temp = stack.pop();
			 }
			 
			 System.out.print(temp.data+" ");
			 temp = temp.right;
		 }
	 }
	 
	 //method to traverse the tree in postorder
	 void postorder(Node<T> root) {
		 
		 Node<T> q = root;
		 Node<T> temp = root;
		 
		 while(true) {
			 
			 while(temp.left != null) {
				 stack.push(temp);
				 temp = temp.left;
			 }
			 
			 while(temp.right == null || temp.right == q) {
				 
				 System.out.print(temp.data+" ");
				 q = temp;
				 
				 if(stack.empty()) return;
				 temp = stack.pop();
			 }
			 
			 stack.push(temp);
			 temp = temp.right;
		 }
	 }
	 
	 //method to traverse the tree in Level order
	 void levelorder(Node<T> root) {
		 
		 java.util.Queue<Node<T>> q = new java.util.LinkedList<>();
		 q.add(root);
		 
		 while(!q.isEmpty()) {
			 
			 Node<T> current = q.peek();
			 
			 System.out.print(current.data+" ");
			 if(current.left != null)q.add(current.left);
			 if(current.right != null)q.add(current.right);
			 q.remove();
		 }
		 	 
	 }
	 
	 //method to find the height of the tree
	 int getHeight(Node<T> root) {
		 
		 if(root == null) return 0;
		 return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	 }
	 
	 //method to find the leaf node in the tree
	 int getLeafNodes(Node<T> root) {
		 
		 if(root == null) return 0;
		 if(root.left == null && root.right == null) return 1;
		 return getLeafNodes(root.left) + getLeafNodes(root.right);
	 }
	 
	 //method to find the total node in the tree
	 int getTotalNodes(Node<T> root) {
		 
		 if(root == null) return 0;
		 return 1 + getTotalNodes(root.left) + getTotalNodes(root.right);
	 }
	 
	 //method to find the internal node in the tree
	 int getInternalNodes(Node<T> root) {
		 
		 return getTotalNodes(root) - getLeafNodes(root);
	 }
	 
}

//Main class
public class GenericBinaryTree{
	
	public static void main(String[] args) {
		
		BinaryTree<Integer> btree = new BinaryTree<>();
		
		System.out.println("Create a binary tree: ");
		Node<Integer> root = btree.createBT();
		
		System.out.print("\nPreorder: ");
		btree.preorder(root);
		
		System.out.print("\nPostorder: ");
		btree.postorder(root);
		
		System.out.print("\nInorder: ");
		btree.inorder(root);
		
		System.out.print("\nLevel order: ");
		btree.levelorder(root);
		
		System.out.println("\nHeight of the tree: "+btree.getHeight(root));
		System.out.println("Total number of leaf nodes: "+btree.getLeafNodes(root));
	}

}
