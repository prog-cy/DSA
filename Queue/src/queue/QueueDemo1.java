package queue;

import java.util.Arrays;

//Implementing queue using array

//In this class I have implemented all the Queue operations
class Queue{
	
	private int front = -1;
	private int rear = -1;
	
	private int[] queue = new int[5];
	
	//Method to insert data in the queue
	void enqueue(int data) {
		
		if(isFull()) {System.out.println("Overflow"); return;}
		if(front == -1)
			front = 0;
		queue[++rear] = data;
		System.out.println(data + " inserted in queue");
		
	}
	
	//Method to delete data from the queue
	int dequeue() {
		if(isEmpty()) {System.out.println("Underflow"); return Integer.MIN_VALUE;}
		return queue[front++];
		
	}
	 
	//this method will return first element of the queue
	int front() {
		if(isEmpty()) {System.out.println("Underflow"); return Integer.MIN_VALUE;}
		return queue[front];
	}
	
	//this method will return last element of the queue
	int rear() {
		if(isEmpty()) {System.out.println("Underflow"); return Integer.MIN_VALUE;}
		return queue[rear];
	}
	
	//this method will check that queue is full or not
	boolean isFull() {
		if(isEmpty())
			return false;
		return (rear == queue.length-1);
	}
	
	//this method will check that queue is empty or not
	boolean isEmpty() {
		return (front == -1 || front == rear+1);
	}
	
	//method to display the queue in list format
	void asList() {
		System.out.println(Arrays.toString(queue));
	}
	
	//method to display the queue
	void display() {
		if(isEmpty()) {
			System.out.println("Underflow");
		}
		else {
			
			for(int i = front; i<=rear; i++)
				System.out.print(queue[i]+" ");
		}
	}
}

//Main class 
public class QueueDemo1 {
	
	//main method
	public static void main(String[] args) {
		
		Queue q1 = new Queue(); //this is object of Queue class
		
		System.out.println("Queue is empty: "+q1.isEmpty());
		 
		q1.enqueue(10);
		q1.enqueue(20);
		q1.enqueue(30);
		q1.enqueue(40);
		q1.enqueue(50);
		
		System.out.println("Queue as list: ");
		q1.asList();
		System.out.println("Queue is: ");
		q1.display();
		System.out.println();
		System.out.println("Queue is full: "+q1.isFull());
		System.out.println("First element in queue: "+q1.front());
		System.out.println("Last element in queue: "+q1.rear());
		System.out.println("Last element in queue: "+q1.rear());
		System.out.println("Element deleted from the queue: "+q1.dequeue());
		System.out.println("First element in queue: "+q1.front());
		System.out.println("Last element in queue: "+q1.rear());
		System.out.println("Element deleted from the queue: "+q1.dequeue());
		System.out.println("First element in queue: "+q1.front());
		System.out.println("Last element in queue: "+q1.rear());
		System.out.println("Queue is empty: "+q1.isEmpty());
		System.out.println("Queue is full: "+q1.isFull());
	}

}
