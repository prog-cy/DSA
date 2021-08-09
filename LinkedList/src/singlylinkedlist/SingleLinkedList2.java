package singlylinkedlist;

//In previous program I have created Node class as separate class 
//But in this program I will create a Node class as inner class of SingleLinkedList2 class

public class SingleLinkedList2 {
	
	//creating inner class named as Node to create a node
	class Node{
		
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	
	//creating three nodes of single linked list
	Node node1 = new Node(12);
	Node node2 = new Node(34);
	Node node3 = new Node(45);

	public static void main(String[] args) {
		
		Node head;
		Node tail;
		
		SingleLinkedList2 ob = new SingleLinkedList2();
	
		
		head = ob.node1;
		tail = ob.node1;
		
		tail.next = ob.node2;
		tail = ob.node2;
		
		tail.next = ob.node3;
		tail = ob.node3;
		
		//calling printList method to traverse a linked list
		System.out.println("Data present at the reference");
		ob.printList(head);
	}
	
	//this method is used to traverse single linked list
	void printList(Node head) {
		Node temp = head;
		
		while(temp != null) {
			System.out.println(temp.data+" present at ->"+temp);
			temp = temp.next;
		}
	}

}
