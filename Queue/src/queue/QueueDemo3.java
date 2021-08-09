package queue;

import java.util.Stack;

//implementing queue using double stack
class Queue3{
	
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	
	//method to insert data in the queue
	void enqueue(int data) {
		
		stack1.push(data);
		System.out.println(data+" inserted in the queue");
	}
	
	//method to delete data from the queue
	int dequeue() {
		
		while(!stack1.empty())
			stack2.push(stack1.pop());
		
		int val =  stack2.pop();
		
		while(!stack2.empty())
			stack1.push(stack2.pop());
		System.out.println(val+" deleted from the queue");
		return val;
	}
	
	//method to get first element in the queue
	int front() {
		
		if(isEmpty()) {System.out.println("Underflow"); return Integer.MIN_VALUE;}
		
		while(!stack1.empty())
			stack2.push(stack1.pop());
		int val = stack2.peek();
		
		while(!stack2.empty())
			stack1.push(stack2.pop());
		return val;
	}
	
	//method to get last element in the queue
	int rear() {
		if(isEmpty()) {System.out.println("Underflow"); return Integer.MIN_VALUE;}
		return stack1.peek();
	}
	//method to check that queue is empty or not
	boolean isEmpty() {
		
		return stack1.empty();
	}
	
	//method to display the queue
	void diplay() {
		
		if(isEmpty()) {System.out.println("Underflow"); return;}
		for(int i = 0; i<stack1.size(); i++)
			System.out.print(stack1.get(i)+" ");
		System.out.println();
	}
}

//Main class 
public class QueueDemo3 {
	public static void main(String[] args) {
		
		Queue3 q1 = new Queue3();
		
		System.out.println("Queue is empty: "+q1.isEmpty());
		
		q1.enqueue(10);
		q1.enqueue(20);
		q1.enqueue(30);
		q1.enqueue(40);
		q1.enqueue(50);
		q1.enqueue(60);
		
		System.out.println("Data present in the queue");
		q1.diplay();
		
		System.out.println("Queue is empty: "+q1.isEmpty());
		
		System.out.println("First element in the queue: "+q1.front());
		System.out.println("Last element in the queue: "+q1.rear());
		
		q1.dequeue();
		System.out.println("Data present in the queue");
		q1.diplay();
		
		System.out.println("First element in the queue: "+q1.front());
		System.out.println("Last element in the queue: "+q1.rear());
		
		while(!q1.isEmpty())
			q1.dequeue();
		
		System.out.println("Queue is empty: "+q1.isEmpty());
		System.out.println("First element in the queue: "+q1.front());
		System.out.println("Last element in the queue: "+q1.rear());
		
		
		q1.enqueue(70);
		q1.enqueue(80);
		System.out.println("Queue is empty: "+q1.isEmpty());
		System.out.println("First element in the queue: "+q1.front());
		System.out.println("Last element in the queue: "+q1.rear());
	}
}
