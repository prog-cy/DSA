package doublycircularlinkedlist;

public class CircularDoublyLinkedList1 {
	
	Node head = null; // Initialize the head of the list
	Node tail = null; //Initialize the tail of the list
	
	//creating Node class
	class Node{
		Node prev;
		int data;
		Node next;
		
		Node(int data){this.data = data;}
	}
	
	//method to insert node at the beginning of the list
	void push(int data) {
		
		Node newnode = new Node(data);
		
		if(head == null) {
			head = newnode;
			tail = newnode;
			head.prev = head;
			head.next = head;
		}
		else {
			head.prev = newnode;
			tail.next = newnode;
			newnode.next = head;
			newnode.prev = tail;
			head = newnode;
		}
	}
	
	//method to insert at the end of the circular linked list
	void append(int data) {
		
		Node newnode = new Node(data);
		if(head == null) {
			push(data);
		}
		else {
			newnode.prev = tail;
			newnode.next = head;
			head.prev = newnode;
			tail.next = newnode;
			tail = newnode;
		}
	}
	
	//method to delete the node from the list by index
	void removeAt(int index) {
		if(index < 0 || index >= size()) {
			System.out.println("Invalid Index");
			return;
		}
		else if(index == 0) {
			head.next.prev = head.prev;
			head = head.next;
			tail.next = head;
		}
		else if(index == size()-1) {
			tail.prev.next = tail.next;
			tail = tail.prev;
			head.prev = tail;
		}
		else {
			Node temp = head;
			int i = 0;
			while(i<index) {
				temp = temp.next;
				i++;
			}
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
		}
	}
	
	//this method will count total number of nodes present in the list
	int size() {
		if(head == null) {
			return -1;
		}
		else {
			Node temp = head;
			int count = 0;
			
			do {
				temp = temp.next;
				count++;
			}while(temp != head);
			
			return count;
		}
	}
	
	//this method will check that list is circular or not
	boolean isCircular() {
		  
		return (head == tail.next); //this line will return true if circular o/w false.
	}
	//method to display the data of the list
	void display() {
		
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		else {
			Node temp = head;
			do {
				System.out.print(temp.data+" ");
				temp = temp.next;
			}while(temp != head);
			System.out.println();
		}
	}
	//main method
	public static void main(String[] args) {
		CircularDoublyLinkedList1 ls1 = new CircularDoublyLinkedList1();
		
		ls1.push(12);
		ls1.push(13);
		ls1.push(50);
		ls1.push(56);
		
		ls1.append(78);
		ls1.append(100);
		ls1.push(67);
		ls1.display();
		ls1.removeAt(1);
		ls1.display();
		ls1.removeAt(0);
		ls1.display();
		ls1.removeAt(ls1.size()-1);
		ls1.display();
		
		ls1.push(89);
		ls1.display();
		ls1.append(100);
		ls1.display();
		
		System.out.println("List is circular: "+ls1.isCircular());
		System.out.println("Size of the list is: "+ls1.size());
	}

}
