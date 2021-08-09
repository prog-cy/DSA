package singlylinkedlist;

import java.util.ArrayList;

public class SingleLinkedListDetectLoop {
	
	Node head = null;
	Node tail = null;
	//creating a Node class 
	class Node{
		
		int data;
		Node next;
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	
	//method to detect a loop;
	//this method will use ArrayList to contains the address of each node
	boolean detectLoop() {
		
		Node h = head;
		ArrayList<Node> list = new ArrayList<>();
		
		while(h != null) {
			
			if(list.contains(h))
				return true;
			list.add(h);
			h = h.next;
		}
		return false;
	}
	
	//adding data in the linked list
	void push(int data) {

		Node node = new Node(data);
		
		if(head == null) {
			head = node;
			tail = node;
		}
		else {
			tail.next = node;
			tail = node;
		}
	}
	
	//this method will create a loop in list 
	void createloop(int pos) {
		
		Node temp = head;
		
		int i = 1;
		while(i<pos) {
			temp = temp.next;
			i++;
		}
		
		if(pos != 0 && pos > 0)
			tail.next = temp;
	}
	
	void display() {
		
		if(head == null)System.out.println("List is empty");
		else {
			Node t = head;
			while(t != null) {
				System.out.print(t.data+" ");
				t = t.next;
			}
			System.out.println();
		}
	}
	
	//driver method
	public static void main(String[] args) {
		
		SingleLinkedListDetectLoop ls = new SingleLinkedListDetectLoop();
		
		ls.push(12);
		ls.push(34);
		ls.push(45);
		ls.push(67);
		ls.push(89);
		
		ls.display();
		ls.createloop(3);
		
		
		
		if(ls.detectLoop())
			System.out.println("Loop is found");
		else
			System.out.println("Loop is not found");
	
	}

}
