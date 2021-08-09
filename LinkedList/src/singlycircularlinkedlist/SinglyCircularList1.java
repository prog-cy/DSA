package singlycircularlinkedlist;

public class SinglyCircularList1 {
	
	Node head = null; // head of the list
	
	//Creating Node class
	class Node{
		
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	
	//method to create a node in circular list
	void createNode(int data) {
		
		if(head == null) {
			push(data);
		}
		else {
			append(data);
		}
	}
	
	//insert at beginning in the circular linked list
	void push(int data) {
		
		Node node = new Node(data);
		
		if(head == null) {
			head = node;
			head.next = head;
		}
		
		else {
			Node temp = head;
			while(temp.next != head)
				temp = temp.next;
			node.next = head;
			head = node;
			temp.next = head;
		}
		
	}
	
	//this method will add the data at the end of a circular list
	void append(int data) {
		
		Node node = new Node(data);
		
		if(head == null) {
			head = node;
			head.next = head;
		}
		else {
			Node temp = head;
			while(temp.next != head) {
				temp = temp.next;
			}
			temp.next = node;
			node.next = head;
		}
	}
	//method to delete a node at given index
	void removeAt(int index) {
		if(head == null) System.out.println("List is empty");
		else if(index == 1) {
			deleteFirst();
		}
		else if(index == size()) {
			deleteLast();
		}
		else {
			Node temp = head;
			int i = 1;
			while(i<index-1) {
				temp = temp.next;
				i++;
			}
			temp.next = temp.next.next;
		}
	}
	
	//this method will remove the first node from the list
	void deleteFirst() {
		if(head == null) {System.out.println("List is empty");}
		else {
			Node temp = head;
			while(temp.next != head){
				temp = temp.next;
			}
			
			head = head.next;
			temp.next = head;
		}
	}
	
	//this method will remove the last node from the list
	void deleteLast() {
		if(head == null) System.out.println("List is empty");
		else {
			Node temp = head.next;
			while(temp.next.next != head)
				temp = temp.next;
			temp.next = head;
		}
	}
	
	//this method will remove the whole list
	void removeAll() {head = null;}
	
	//method to traverse the circular list
	void display() {
		
		if(head == null) {System.out.println("List is empty");}
		else {
			Node temp = head;
			do{
				System.out.print(temp.data+" ");
				temp = temp.next;
			}while(temp != head);
			System.out.println();
		}
	}
	
	//count total number of elements in the list
	int size() {
		
		int count = 0;
		
		if(head == null) return 0;
		else {
			Node temp = head;
			
			do {
				count++;
				temp = temp.next;
			}while(temp != head);
		}
		return count;
	}
	
	
	//this method will return a value present at given index
	int get(int index) {
		
		if(head == null) {
			System.out.println("List is empty");
			return -1;
		}
		else {
			
			Node temp = head;
			int i = 1;
			while(i<index) {
				temp = temp.next;
				i++;
			}
			
			return temp.data;
		}
		
	}
	
	//check circular
	void isCircular() {
		
		if(head == null) {
			System.out.println("List is circular");
			return;
		}
		Node temp = head.next;
		
		while(temp != head)
			temp = temp.next;
		if(temp == head)
			System.out.println("List is circular");
		else
			System.out.println("List is not circular");
	}
	
	
	//main() driver code to run all the above method so that it can be very efficient 
	public static void main(String[] args) {
		
		SinglyCircularList1 ls1 = new SinglyCircularList1();
		
		ls1.createNode(12);
		ls1.createNode(13);
		ls1.createNode(14);
		ls1.createNode(15);
		ls1.createNode(16);
		ls1.createNode(17);
		ls1.createNode(19);
		ls1.createNode(78);
		ls1.createNode(90);
		ls1.createNode(100);
		
		System.out.println("Data present in the list");
		ls1.display();
		ls1.isCircular();
		ls1.push(45);
		ls1.display();
		ls1.isCircular();
		ls1.push(78);
		ls1.display();
		ls1.isCircular();
		ls1.push(89);
		ls1.append(102);
		ls1.display();
		ls1.createNode(101);
		ls1.display();
		ls1.isCircular(); 
		System.out.println("\nSize of the list: "+ls1.size());
		ls1.removeAt(2);
		ls1.display();
		ls1.removeAt(1);
		ls1.display();
		ls1.removeAt(13);
		ls1.display();
		ls1.removeAt(12);
		ls1.display();
		ls1.removeAll();
		ls1.display();
		System.out.println("\nSize of the list: "+ls1.size());
		System.out.println("Data present at position "+2+" is "+ls1.get(2)); 
	}

}
