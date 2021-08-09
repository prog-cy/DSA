package singlylinkedlist;

//creating a singly linked list with 3 nodes
//This is Node class used to create a Node object which contains data and reference to the next node
class Node{
	
	int data;
	Node next;
}

public class SingleLinkedList1 {
	
	public static void main(String[] args) {
		//creating an object of Node class named as head
		Node head = null;
		Node tail = null;
		
		//node1
		Node node1 = new Node();
		node1.data = 12;
		head = node1;
		tail = node1;
		
		//node2
		Node node2 = new Node();
		node2.data = 34;
		tail.next = node2;
		tail = node2;
		
		//node3
		Node node3 = new Node();
		node3.data = 45;
		tail.next = node3;
		tail = node3;
		tail.next = null;
		
		//calling the printList method to traverse the single linked list
		System.out.println("Data present at the reference");
		new SingleLinkedList1().printList(head);
	}
	
	//this method prints the data present in the list
	void printList(Node ref) {
		Node temp = ref;
		
		while(temp != null) {
			System.out.println(temp.data+" present at location-> "+temp);
			temp = temp.next;
		}
	}	
}
