package circularqueue;

//implementing circular queue using array

class CircularQueue{
	
	private int front = -1;
	private int rear = -1;
	private int size = 5;
	
	private int[] queue = new int[size];
	
	//method to insert data in the circular queue
	void enqueue(int data) {
		
		if(isFull()) { 
			System.out.println("Overflow");
			return;
		}
		if(front == -1)
			front = 0;
		if(rear == size - 1 && front != 0)
			rear = 0;
		else 
			rear += 1;
		queue[rear] = data;
		System.out.println(data+" inserted in the queue");	
	}
	
	//method to delete data from the circular queue
	int dequeue() {
		
		if(isEmpty()) {
			System.out.println("Underflow");
			return Integer.MIN_VALUE;
		}
		
		int item = queue[front];
	    if(front == rear - 1) {
			front = 0;
	    }
		else if(front == rear) {
			front = rear = -1;
		}
		else
			front += 1;
	    
	    System.out.println(item+" deleted from the queue");
	    return item;
	}
	
	//this method will check that queue is full or not
	boolean isFull() {
		
		return ((rear == size-1 && front == 0) || (rear == front - 1));
	}
	
	//this method will check that queue is empty or not
	boolean isEmpty() {
		
		return (front == -1);
	}
	
	
	//method to display the data of the circular queue
	void display() {
		
		if(isEmpty()) {System.out.println("Underflow"); }
			
		if(front <= rear) {
		      for(int i = front; i<=rear; i++)
			       System.out.print(queue[i]+" ");
		}
		else {
			
			int i = front;
			while(i<size)
				System.out.print(queue[i++]+" ");
			i = 0;
			while(i<=rear)
				System.out.print(queue[i++]+" ");
		}
		
		System.out.println();
	}
}

//main class
public class CircularQueueDemo {
	public static void main(String[] args) {
		
		CircularQueue cq1 = new CircularQueue();
		
		cq1.enqueue(10);
		cq1.enqueue(20);
		cq1.enqueue(30);
		cq1.enqueue(40);
		cq1.enqueue(50);
		
		System.out.println("Data present in the queue: ");
		cq1.display();
		
		cq1.dequeue();
		
		System.out.println("Data present in the queue: ");
		cq1.display();
		
		cq1.enqueue(60);
		System.out.println("Data present in the queue: ");
		cq1.display();
		
		cq1.dequeue();
		cq1.dequeue();
		
		System.out.println("Data present in the queue: ");
		cq1.display();
		
		
		cq1.enqueue(70);
		System.out.println("Data present in the queue: ");
		cq1.display();
		
		cq1.dequeue();
		cq1.dequeue();
		System.out.println("Data present in the queue: ");
		cq1.display();
		
		cq1.enqueue(80);
		cq1.enqueue(90);
		cq1.enqueue(100);
		
		System.out.println("Data present in the queue: ");
		cq1.display();
		
	}
}
