package deque;

import java.util.LinkedList;

//Implementing  Dequeue using doubly linked list

class Deque1{
	
	//It is built-in doubly linked list provided by java
	LinkedList<Integer> ls = new LinkedList<>();
	
	//method to insert at front of the dequeue
	void insertfront(int data) {
		ls.push(data);
		System.out.println(data+" inserted at front end");  
		
	}
	
	//method to insert at rear of the dequeue
	void insertrear(int data) {
		ls.add(data);
		System.out.println(data+" inserted at rear end");
	}
	
	//method to delete from the front of the dequeue
	int deletefront() {
		
		if(ls.isEmpty()) {System.out.println("Underflow"); return Integer.MAX_VALUE;}
		System.out.println(ls.getFirst()+" deleted from front end");
		return ls.removeFirst();
	}
	
	//method to delete from the end of the queue
	int deleterear() {
		if(ls.isEmpty()) {System.out.println("Underflow"); return Integer.MIN_VALUE;}
		System.out.println(ls.getLast()+" deleted from rear end");
		return ls.removeLast();
	}
	
	//method to get front of the queue
	int getFront() {
		
		if(ls.isEmpty()) {System.out.println("Underflow"); return Integer.MIN_VALUE;}
		return ls.getFirst();
	}
	
	int getRear() {
		if(ls.isEmpty()) {System.out.println("Underflow"); return Integer.MIN_VALUE;}
		return ls.getLast();
	}
	
	//method to display the dequeue
	void display() {
		
		for(int i = 0; i<ls.size(); i++) {
			System.out.print(ls.get(i)+" ");
		}
		System.out.println();
	}
		
}

//main class
public class DequeDemo1 {
	
	public static void main(String[] args) {
		
		Deque1 q1 = new Deque1();
		
		q1.insertfront(10);
		q1.insertfront(20);
		
		q1.insertrear(40);
		q1.insertrear(60);
		
		System.out.println("Data present in dequeue");
		q1.display();
		System.out.println("Data present at the front of the queue: "+q1.getFront());
		System.out.println("Data present at the last of the queue: "+q1.getRear());
		
		q1.deletefront();
		System.out.println("Data present in dequeue");
		q1.display();
		
		q1.deleterear();
		System.out.println("Data present in dequeue");
		q1.display();
		
		q1.insertfront(90);
		System.out.println("Data present in dequeue");
		q1.display();
		
		q1.insertrear(100);
		System.out.println("Data present in dequeue");
		q1.display();
		
		q1.deletefront();
		System.out.println("Data present in dequeue");
		q1.display();	
	}

}
