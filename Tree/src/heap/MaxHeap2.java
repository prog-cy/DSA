package heap;

import java.util.ArrayList;

import java.util.List;

// Implementing Heap using Dynamic array 

public class MaxHeap2 {
	
	static ArrayList<Integer> maxheap = new ArrayList<>(); //declaring dynamic array
	
	//method to insert in the heap
	static void insert(int key) {
		
		maxheap.add(key);
		
		int i = maxheap.size()-1;
		
		while(i > 0) {
			
			int parent = (i-1)/2;
			
			if(maxheap.get(parent) < maxheap.get(i)) {
				
				int temp = maxheap.get(parent);
				maxheap.set(parent, maxheap.get(i));
				maxheap.set(i, temp);
			}
			
			i = parent;
		}
	}
	
	//method to display the heap in level order
	static void display(List<Integer> ls) {
		
		for(int i = 0; i<ls.size(); i++)
			System.out.print(ls.get(i)+" ");
	}
	
	//method to get max from Max Heap
	static int getMax() {
		
		return maxheap.get(0);
	}
	
	
	//main method
	public static void main(String[] args) {
		
		
		insert(5);
		insert(9);
		insert(8);  
		insert(7);
		insert(6);
		insert(10);
		insert(40); 
		insert(100);
		insert(90);
		insert(1);
		insert(-1);
		
		
		System.out.print("Max Heap: ");
		display(maxheap);
	
		System.out.println("\nMaximum value in the Heap: "+getMax());
		
	}

}
