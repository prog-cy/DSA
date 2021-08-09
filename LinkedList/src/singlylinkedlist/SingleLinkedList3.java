package singlylinkedlist;

import java.util.Scanner;

public class SingleLinkedList3 {
	
	Node head = null; //Initialize head
	Node tail = null; //Initialize tail
	
	//class to create a Node.
	class Node{
		
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	
	//1. this method is used to create a new node in the list
	void createNewNode(int data) {
		if(head == null) {
			push(data);
		}
		else {
			append(data);
		}
		
	}
	
	//2. this method adds data at the beginning of a list
	void push(int data) {
		
		Node newnode = new Node(data);
		if(head == null) {
			head = newnode;
			tail = head;
		}
		
		else {
			newnode.next = head;
			head = newnode;
		}
	}
	
	//3. method to insert after a node
	void insertAfter(int pos, int data) {
		
		if(pos<1) System.out.println("Invalid position of node");
		else if(head == null)System.out.println("List is empty");
		else {
			Node newnode = new Node(data);
			Node temp = head;
			
			int i = 1;
			while(i<pos) {
				temp = temp.next;
				i++;	
			}
			
			if(temp == tail) {
				newnode.next = temp.next;
				temp.next = newnode;
				tail = newnode;
			}
			else {
				newnode.next = temp.next;
				temp.next = newnode;
			}
					
		}
	}
	
	//4. method to insert at end of the list
	void append(int data) {
		Node newnode = new Node(data);
		if(head == null) {
			head = newnode;
		}
		else {
			
			tail.next = newnode;
			tail = newnode;
		}
	}
	
	//5. method to insert before the given node
	void insertBefore(int pos, int data) {
		
		if(head == null)System.out.println("List is empty");
		else {
			Node newnode = new Node(data);
			Node temp = head;
			
			int i = 1;
			while(i<pos-1) {
				temp = temp.next;
				i++;
			}
			
			newnode.next = temp.next;
			temp.next = newnode;
		}
	}
	
	//6. this method will remove a node of given key in the list
		//1. Iterative approach
	void remove(int key) {
		
		if(head == null)System.out.println("List is empty");
		else {
			Node temp = head;
			Node prev = null;
			
			
			while(true) {
				
				if(temp.data == key && prev == null) {
					head = temp.next;
					return;
				}
				
				else if(temp.data == key)
					break;
				prev = temp;
				temp = temp.next;
			}
			
			if(temp.next == null) { tail = prev;}
			
			prev.next = temp.next;
				
			
		}
	}
	
		//2. this method will also remove element from the list of given key
	void remove(Node prev, Node temp, int key) {
		  
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		
		else if(temp.data == key && prev == null) {
			head = temp.next;
			return;
		}
		
		if(temp.next == null) {tail = prev;}
		
		if(temp.data == key) {
			prev.next = temp.next;
			return;
		}
		remove(temp, temp.next, key);
	}
	
	//7. this method will remove a node from a given position
	void removeAt(int pos) {
		if(head == null) System.out.println("List is empty");
		else if(pos == 1) {
			head = head.next;
		}
		else if(pos == size(head)) {
			Node temp = head;
			int i = 1;
			while(i<pos-1) {
				temp = temp.next;
				i++;
			}
			
			temp.next = temp.next.next;
			tail = temp;
		}
		else {
			Node temp = head;
			int i = 1;
			while(i<pos-1) {
				temp = temp.next;
				i++;
			}
			
			temp.next = temp.next.next;
		}
	}
	
	//8. this method will remove all the element of the list
	void removeAll() { head = null; }
	
	//9. this method will count all the elements in the list recursively
	int size(Node temp) {
		
		if(temp == null) return 0;
		return 1 + size(temp.next);
	}
	
	//10. this method will return value present at the given index
	int get(int index) {
		
		Node temp = head;
		int i = 1;
		while(i<index) {
			temp = temp.next;
			i++;
		}
		
		return temp.data;
	}
	
	//11. this method will reverse the list
	void reverse() {
		Node prev = null;
		Node current = head;
		Node temp = null;
		
		if(head == null) {System.out.println("List is empty");}
		
		else {
			while(current != null) {
				temp = current.next;
				current.next = prev;
				prev = current;
				current = temp;
			}
			tail = head;
			head.next = null;
			head = prev;
		}
	}
	//12. this method used to traverse a list
	void printList(Node head) {
		
		Node temp = head;
		if(head == null) {System.out.println("List is empty"); return;}
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	//main() method 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SingleLinkedList3 ob = new SingleLinkedList3();
		
	    outer : while(true) {
			System.out.println("1. Create a list");
			System.out.println("2. Display");
			System.out.println("3. Count");
			System.out.println("4. Insert at beginning");
			System.out.println("5. Insert after");
			System.out.println("6. Insert at end");
			System.out.println("7. Insert before");
			System.out.println("8. Delete a node of given key");
			System.out.println("9. Delete a node from list recursively");
			System.out.println("10. Delete a node at given index");
			System.out.println("11. Delete entire list");
			System.out.println("12. Get value present at given position");
			System.out.println("13. Reverse list");
			System.out.println("14. exit...");
			
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter data");
				int data = sc.nextInt();
				ob.createNewNode(data);
				break;
			case 2:
				System.out.println("Data present in the list");
				ob.printList(ob.head);
				break;
			case 3:
				System.out.println("Total number of nodes: "+ob.size(ob.head));
				break;
			case 4:
				System.out.println("Enter data");
				data = sc.nextInt();
				ob.push(data);
				break;
			case 5:
				System.out.println("Enter data");
				data = sc.nextInt();
				System.out.println("Enter position of the node");
				int pos = sc.nextInt();
				ob.insertAfter(pos, data);
				break;
			case 6:
				System.out.println("Enter data");
				data = sc.nextInt();
				ob.append(data);
				break;
			case 7:
				System.out.println("Enter data");
				data = sc.nextInt();
				System.out.println("Enter position of the node");
				pos = sc.nextInt();
				ob.insertBefore(pos, data);
				break;
			case 8:
				System.out.println("Enter key which you want to delete");
				int key = sc.nextInt();
				ob.remove(key);
				break;
			case 9:
				System.out.println("Enter key which you want to delete");
				key = sc.nextInt();
				ob.remove(null, ob.head, key);
				break;
			case 10:
				System.out.println("Enter position of the node which you want to delete");
				pos = sc.nextInt();
				ob.removeAt(pos);
				break;
			case 11:
				ob.removeAll();
				break;
			case 12:
				System.out.println("Enter position of node, which value you want to access");
				pos = sc.nextInt();
				System.out.println("Value present at position "+pos+": "+ob.get(pos));
				break;
			case 13:
				ob.reverse();
				break;
			case 14:
				break outer;
			default:
				System.out.println("Invalid choice");
				
			}
			
		}
		System.out.println("Successfully completed all operations");
		sc.close();
		
	}

}
