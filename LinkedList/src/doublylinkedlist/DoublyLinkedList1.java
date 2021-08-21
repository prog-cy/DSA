package doublylinkedlist;

public class DoublyLinkedList1 {
	
	Node head = null; //Initialize the head node;
	Node tail = null; //Initialize the tail node;
	
	
	//this is Node class to create a doubly linked list
	class Node{
		
		Node prev;
		int data;
		Node next;
		Node(int data){this.data = data;}
	}
	
	//method to insert at the front of the DLL 
	void push(int data) {
		Node newnode = new Node(data);
		if(head == null) {
			newnode.prev = null;
			head = newnode;
			tail = newnode;
			newnode.next = null;
		}
		else {
			head.prev = newnode;
			newnode.next = head;
			head = newnode;
			newnode.prev = null;
		}
	}
	
	//method to add after a given node index
	void addAfter(int data, int pos) {
		if(pos<=0 || pos > size()) {
			System.out.println("Invalid position of node");
			return;
		}
		else if(head == null) {
			System.out.println("List is empty");
			return;
		}
		else if(pos == size()) append(data);
		else {
			Node newnode = new Node(data);
			Node temp = head;
			int i = 1;
			while(i<pos) {
				temp = temp.next;
				i++;
			}
			newnode.prev = temp;
			newnode.next = temp.next;
			temp.next.prev = newnode;
			temp.next = newnode;
			
		}
	}
	
	//this method is used to count total number of nodes present in the DLL
	int size() {
		
		if(head == null) {System.out.println("List is empty"); return -1;}
		else {
			int count = 0;
			Node temp = head;
			while(temp != null) {
				temp = temp.next;
				count++;
			}
			return count;
		}
		
	}
	//Method to insert at the end of the list
	void append(int data) {
		
		Node newnode = new Node(data);
		
		if(head == null) {
			newnode.prev = null;
			head = newnode;
			tail = newnode;
			
		}
		else {
			newnode.prev = tail;
			tail.next = newnode;
			tail = newnode;	
		}
		
		tail.next = null;
	}
	
	//this method is used to add node before the position of given node
	void addBefore(int data, int pos) {
		if(pos<=0 || pos > size()) {
			System.out.println("Invalid position of node");
			return;
		}
		else if(head == null || pos == 1) {push(data); return ;}
		else {
			Node newnode = new Node(data);
			Node temp = head;
			int i = 1;
			while(i<pos-1) {
				temp = temp.next;
				i++;
			}
			newnode.prev = temp;
			newnode.next = temp.next;
			temp.next.prev = newnode;
			temp.next = newnode;	
		}
	}
	
	//this method is used to delete a node by index using 0 based indexing
	void removeAt(int index) {
		if(index<0 || index >= size() || head == null) {
			System.out.println("Invalid index ");
			return;
		}
		else if(index == 0) {
			head.next.prev = null;
			head = head.next;
		}
		else if(index == size()-1) {
			tail.prev.next = null;
			tail = tail.prev;
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
	
	//method to delete entire DLL
	void removeAll() {head = null;}
	
	//method to reverse the DLL
	void reverse() {
		if(head == null) {
			System.out.println("\nList is empty");
			return;
		}
		else {
			Node current = head;
			Node temp = null;
			
			while(current != null) {
				temp = current.prev;
				current.prev = current.next;
				current.next= temp;
				current = current.prev;
			}
			Node t = tail;
			tail = head;
			head = t;
		}
	}
	
	//method to get the data from the DLL by index
	int get(int index) {
		if(index<0 || index >= size()) {
			System.out.println("List is empty");
			return 0;
		}
		else if(index == 0) {
			return head.data;
		}
		else if(index == size()-1){
			return tail.data;
		}
		else {
			Node temp = head;
			int i = 0;
			while(i<index) {
				temp = temp.next;
				i++;
			}
			return temp.data;
		}
	}
	
	//method to display the list
	void display() {
		if(head == null)System.out.println("\nList is empty");
		else{
			Node temp = head;
			while(temp != null) {
				System.out.print(temp.data+" ");
				temp = temp.next;
			}
			System.out.println();
		}
	}
	
	//main method 
	public static void main(String[] args) {
		DoublyLinkedList1 ls1 = new DoublyLinkedList1();
		
		ls1.push(12);
		ls1.push(34);
		ls1.append(67);
		ls1.append(89);
		ls1.push(90);
		
		ls1.push(100);
		ls1.append(34);
		ls1.push(89);
		ls1.append(45);
		ls1.addAfter(11, 2);
		
		ls1.addBefore(78, 6);
		ls1.append(600);
		ls1.push(6713846);
		
		ls1.removeAt(0);
		ls1.display();
		ls1.removeAt(1);
		ls1.display();
		ls1.push(150);
		ls1.append(300);
		ls1.display();
		ls1.reverse();
		ls1.display();
		ls1.append(345);
		ls1.display();
		ls1.push(500);
		ls1.display();
		ls1.reverse();
		ls1.display();
		System.out.println("\nValue in the node at index "+1+" : "+ls1.get(1));
		for(int i = 0; i<ls1.size(); i++) {
			System.out.println(ls1.get(i));
		}
		System.out.println("\nSize of the list: "+ls1.size());
		
		
	}

}
