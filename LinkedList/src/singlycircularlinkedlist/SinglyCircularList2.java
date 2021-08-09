package singlycircularlinkedlist;


public class SinglyCircularList2 {
	
	Node head = null; // initialize head pointer 
	
	//class to create node of circular linked list
	class Node{
		
		int data;
		Node next;
		
		Node(int data){this.data = data; next = null; }
	}
	
	//method to insert in sorted circular linked list
	void sortedInsert(int data) {
		
		Node node = new Node(data);
		Node temp = head;
		
		if(head == null) {
			head = node;
			head.next = head;
		}
		
		else if(data <= head.data) {
			
			while(temp.next != head)
				temp = temp.next;
			node.next = head;
			head = node;
			temp.next = node;	
		}
		
		else {
			
			while(temp.next != head && temp.next.data <= data)
				temp = temp.next;
			node.next = temp.next;
			temp.next =  node;
		}
	}
	
	//method to display the list data 
	void display() {
		if(head == null )System.out.println("List is empty");
		else {
			Node temp = head;
			
			do {
				System.out.print(temp.data+" ");
				temp = temp.next;
			}while(temp != head);
		}
	}
	
	public static void main(String[] args) {
		
		SinglyCircularList2 ls2 = new SinglyCircularList2();
		ls2.sortedInsert(45);
		ls2.sortedInsert(12);
		ls2.sortedInsert(67);
		ls2.sortedInsert(11);
		ls2.sortedInsert(100);
		
		ls2.display();
	}

}
