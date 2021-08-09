package queue;

//implementing Queue using Singly linked list
class Queue1 {
	
	Node front = null; //Initializing front of the queue
	Node rear = null; //Initializing rear of the queue
	
	//Creating Node class to create node of linked list
	class Node{
		
		int data;
		Node next;
		Node(int data){this.data = data; next = null;}
	}
	
	//Method to insert in queue
	void enqueue(int data) {
		
		System.out.println(data+" inserted in the queue");
		Node newnode = new Node(data);
		if(isEmpty()) {
			front = newnode;
			rear = newnode;
		}
		else {
			rear.next = newnode;
			rear = newnode;
		}
	}
	
	//method to delete from queue
	int dequeue() {
		
		if(isEmpty()) {System.out.println("Underflow"); return Integer.MIN_VALUE;}
		int val = front.data;
		front = front.next;
		System.out.println(val+" deleted from the queue");
		return val;
		
	}
	
	//method to get first value of the queue
	int front() {
		if(isEmpty()) {System.out.println("Underflow"); return Integer.MIN_VALUE;}
		return front.data;
	}
	
	//method to get last value of the queue
	int rear() {
		
		if(isEmpty()) {System.out.println("Underflow"); return Integer.MIN_VALUE;}
		return rear.data;
	}
	
	//method to check that queue is empty or not
	boolean isEmpty() {
		return (front == null);
	}
	
	//method to display item of the queue
	void display() {
		if(isEmpty()) {System.out.println("Underflow");}
		else {
			
			Node temp = front;
			while(temp != null) {
				System.out.print(temp.data+" ");
				temp = temp.next;
			}
		}
	}
}

//main class
public class QueueDemo2 {
	public static void main(String[] args) {
		
		Queue1 q1 = new Queue1();
		
		q1.enqueue(10);
		q1.enqueue(20);
		q1.enqueue(30);
		q1.enqueue(40);
		
		System.out.println("Data present in the queue ");
		q1.display();
		System.out.println();
		System.out.println("First value in the queue: "+q1.front());
		System.out.println("Last value in the queue: "+q1.rear());
		System.out.println("Value deleted from the queue: "+q1.dequeue());
		
		System.out.println("First value in the queue: "+q1.front());
		System.out.println("Last value in the queue: "+q1.rear());
		System.out.println("Value deleted from the queue: "+q1.dequeue());
		System.out.println("Value deleted from the queue: "+q1.dequeue());
		
		System.out.println("Data present in the queue ");
		q1.display();
		System.out.println();
		
	}

}
