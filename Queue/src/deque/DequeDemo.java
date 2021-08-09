package deque;

//Implementing Dequeue using circular array

class Deque{
	
	private int front = -1;
	private int rear = -1;
	private int size = 5;
	
	private int[] dequeue = new int[size];
	
	
	//method to check that circular array is full or not
	boolean isFull() {
		
		return ((rear == size-1 && front == 0) || (rear == front - 1));
	}
	
	//method to check that circular array is empty or not
	boolean isEmpty() {
		return (front == -1);
	}
	
	//method to insert at rear end
	void insertrear(int data) {
		
		if(isFull()) {
			System.out.println("Overflow");
			return;
		}
		
		if(front == -1 && rear == -1) {
			front = 0;
			rear = 0;
		}
		if(rear == size-1)
			rear = 0;
		else
			rear++;
		dequeue[rear] = data;
		System.out.println(data+" inserted at rear end");
	}
	
	//method to insert at front end
	void insertfront(int data) {
		
		if(isFull()) {
			System.out.println("Overflow");
			return;
		}
		
		if(front == -1 && rear == -1) {
			front = 0;
			rear = 0;
		}
		
		else if(front == 0) 
			front = size-1;
		else 
			front--;
		dequeue[front] = data;
		System.out.println(data+" inserted at front end");
		
	}
	
	//method to delete from front end
	int delfront() {
		
		if(isEmpty()) {System.out.println("Underflow"); return Integer.MIN_VALUE;}
		
		int item = dequeue[front];
		
		if(front == rear) {
			front = rear = -1;
		}
		else if(front == size-1)
			front = 0;
		else
			front++;
		
		System.out.println(item+" deleted from front end");
		return item;
	}
	
	//method to delete from front end
	int delrear() {
		if(isEmpty()) {System.out.println("Underflow"); return Integer.MIN_VALUE;}
		
		int item = dequeue[rear];
		
		if(front == rear) {
			front = rear = -1;
		}
		
		else if(rear == 0)
			rear = size-1;
		else
			rear--;
		System.out.println(item+" deleted from rear end");
		return item;
	}
	
	//method to get first element of the dequeue
	int getFront() {
		
		if(isEmpty()) {System.out.println("Underflow"); return Integer.MIN_VALUE;}
		return dequeue[front];
	}
	
	//method to get last element of the dequeue
	int getRear() {
		if(isEmpty()) {System.out.println("Underflow"); return Integer.MIN_VALUE;}
		return dequeue[rear];
	}
	
	//method to display the element
	void display() {
		
		if(front <= rear) {
			for(int i = front; i<=rear; i++)
				System.out.print(dequeue[i]+" ");
		}
		else {
			
			int i = front;
			
			while(i<size)
				System.out.print(dequeue[i++]+" ");
			i = 0;
			while(i <= rear)
				System.out.print(dequeue[i++]+" ");
		}
		
		System.out.println();
	}
}

//Main class
public class DequeDemo {
	public static void main(String[] args) {
		
		Deque dq1 = new Deque();
		
		dq1.insertfront(10);
		dq1.insertfront(20);
		
		dq1.insertrear(40);
		dq1.insertrear(60);
		
	
		System.out.println("Data present in dequeue");
		dq1.display();
		System.out.println("Data present at the front of the queue: "+dq1.getFront());
		System.out.println("Data present at the last of the queue: "+dq1.getRear());
		dq1.delfront();
		
		System.out.println("Data present in dequeue");
		dq1.display();
		
		dq1.delrear();
		System.out.println("Data present in dequeue");
		dq1.display();
		
		dq1.insertfront(90);
		System.out.println("Data present in dequeue");
		dq1.display();
		
		dq1.insertrear(100);
		System.out.println("Data present in dequeue");
		dq1.display();
		
		dq1.delfront();
		System.out.println("Data present in dequeue");
		dq1.display();
		
		
	}

}
