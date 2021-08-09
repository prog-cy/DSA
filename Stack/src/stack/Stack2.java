package stack;

//Implementing stack using singly linked list

public class Stack2 {
	
	Node root = null; //Initialize the root node
	
	//Creating a Node class
	class Node{
		int data;
		Node next;
		
		Node(int data){this.data = data;}
	}
	
	//method to push data into the stack 
	void push(int data) {
		Node newnode = new Node(data);
		if(root == null) {
			root = newnode;
			newnode.next = null;
		}
		else {
			newnode.next = root;
			root = newnode;
		}
		
	}
	
	//method to pop the element from the stack
	int pop() {
		
		int x = Integer.MIN_VALUE;
		if(root == null) {
			System.out.println("Underflow");
		}
		else {
			x = root.data;
			root = root.next;
		}
		return x;
	}
	
	//method to get the peek element of the stack
	int peek() {
		if(root == null) {
			System.out.println("Underflow");
			return Integer.MIN_VALUE;
		}
		else {
			return root.data;
		}
	}
	
	//method to check that stack is empty or not
	boolean isEmpty() {
		return (root == null);
	}
	
	//method to display the stack data
	void display() {
		if(isEmpty()) {
			System.out.println("Underflow");
		}
		else {
			Node temp = root;
			while(temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}
	//main method 
	public static void main(String[] args) {
		
		Stack2 stk1 = new Stack2();
		
		stk1.push(11);
		stk1.push(12);
		stk1.push(13);
		stk1.push(14);
		System.out.println("Data present in the stack");
		stk1.display();
		
		System.out.println(stk1.pop()+" : is popped from the stack");
		System.out.println("peek element of the stack: "+stk1.peek());
		System.out.println("List is empty: "+stk1.isEmpty());
		stk1.push(15);
		System.out.println("Data present in the stack");
		stk1.display();
	}
}
