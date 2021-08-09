package stack;

//Implementing stack using array

public class Stack1 {
	static final int MAX = 100;
	private int top;
	private int[] stack = new int[MAX];
	
	//constructor to initialize the top
	Stack1() {
		top = -1;
	}
	
	//method to push data into stack
	void push(int data) {
		
		if(top >= (MAX - 1)) {
			System.out.println("Stack Overflow");
			return;
		}
		else {
			stack[++top] = data;
			System.out.println(data+" : pushed into the stack");
		}
	}
	
	//method to delete data from the stack
	int pop(){
		
		if(isEmpty()) {
			System.out.println("Stack is Underflow");
			return 0;
		}
		else {
			return stack[top--];
		}
	}
	
	//method to check that stack is empty or not
	boolean isEmpty() {
		
		return (top<0);
	}
	
	//method to get the top element of the stack
	int peek() {
		
		if(isEmpty()) {
			System.out.println("Stack is Underflow");
			return 0;
		}
		else {
			return stack[top];
		}
	}
	
	//method to return the size of stack
	int size() {
		return top+1;
	}
	
	//method to display the data present in the stack
	void display() {
		for(int i = top; i>=0; i--) {
			System.out.println(stack[i]);
		}
		System.out.println();
	}
	//main method 
	public static void main(String[] args) {
		Stack1 stk1 = new Stack1();

		stk1.push(10);
		stk1.push(20);
		stk1.push(30);
		stk1.push(40);
		
		System.out.println("stack is");
		stk1.display();
		
		System.out.println(stk1.pop()+" : popped from the stack");

		System.out.println("Top of the stack: "+stk1.peek());
		System.out.println("Size of the stack: "+stk1.size());
		
		System.out.println("stack is");
		stk1.display();
	}

}
