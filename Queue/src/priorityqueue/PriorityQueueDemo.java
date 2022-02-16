package priorityqueue;

//Implementing priority queue using sorted linked list

class PriorityQueue{
	
	//class to create a Node of list
	class Node{
		int priority;
		int data;
		Node next;
		Node(int priority, int data){
			this.priority = priority;
			this.data = data;
			next = null;
		}
	}
	
	Node front = null;
	Node rear = null;
	
	//method to insert data in the queue
	void insert(int priority, int data) {
		
		Node newnode = new Node(priority, data);
		
		if(front == null) {
			front = newnode;
			rear = newnode;
		}
		
		else if(priority >= rear.priority) {
			rear.next = newnode;
			rear = newnode;
		}
		else if(priority < front.priority){
			newnode.next = front;
			front = newnode;
		}
		else {
			
			Node temp = front;
			
			while(temp.next.priority<=priority)
				temp = temp.next;
			
			newnode.next = temp.next;
			temp.next = newnode;
		}
	}
	
	//method to delete element from the queue
	int delete() {
		
		if(front == null) {System.out.println("Underflow"); return Integer.MIN_VALUE;}
		int item = front.data;
		front = front.next;
		return item;
	}
	
	//method to get highest priority element of the priority queue
	int getHighestPriority() {
		if(front == null) {System.out.println("Underflow"); return Integer.MIN_VALUE;}
		return front.data;
	}
	//method to display the priority queue
	void display() {
		
		if(front == null) {
			System.out.println("Underflow");
			return;
		}
		Node temp = front;
		while(temp != null) {
			System.out.println(temp.priority+ " --> "+temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
}

//Main class
public class PriorityQueueDemo {
	
	public static void main(String[] args) {
		
		PriorityQueue q1 = new PriorityQueue();
		
		q1.insert(5, 100);
		q1.insert(1, 20);
		q1.insert(2, 34);
		q1.insert(4, 67);
		q1.insert(3, 60);
		q1.insert(2, 30);
		
		
		System.out.println("Element having highest priority is: "+q1.getHighestPriority());
		System.out.println("Data present in priority queue");
		q1.display();
		
		
		q1.delete();
		
		
		System.out.println("Data present in priority queue after deleting");
		q1.display();
		
		
	}
}
