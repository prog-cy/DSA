package heap;

import java.util.ArrayList;

import java.util.*;

// Implementing Heap using Dynamic array 

public class MaxHeap2 {
	
	static ArrayList<Integer> maxheap = new ArrayList<>(); //declaring dynamic array
	static ArrayList<Integer> minheap = new ArrayList<>();
	
	//method to insert in the heap
	static void insert(int key) {
		
		minheap.add(key);
		
		maxheap.add(key);
		
		int i = maxheap.size() -1 ;
		
		while(i > 1) {
			
			int parent = i/2;
			
			if(maxheap.get(parent) < maxheap.get(i)) {
				
				int temp = maxheap.get(parent);
				maxheap.set(parent, maxheap.get(i));
				maxheap.set(i, temp);
			}
			
			if(minheap.get(parent) > minheap.get(i)) {
				
				int temp = minheap.get(parent);
				minheap.set(parent, minheap.get(i));
				minheap.set(i, temp);
			}
			
			i = parent;
		}
	}
	
	//method to display the heap in levelorder
	static void display(List<Integer> ls) {
		
		for(int i = 1; i<ls.size(); i++)
			System.out.print(ls.get(i)+" ");
	}
	
	//method to get max from Max Heap
	static int getMax() {
		
		return maxheap.get(1);
	}
	
	//method to get min from Max Heap
	static int getMin() {
		
		return minheap.get(1); 
	}
	//main method
	public static void main(String[] args) {
		
		maxheap.add(Integer.MAX_VALUE);
		minheap.add(Integer.MIN_VALUE);
		
		insert(5);
		insert(9);
		insert(8);  
		insert(7);
		insert(6);
		insert(10);
		insert(40); 
		insert(90);
		insert(100);
		insert(1);
		insert(-1);
		
		
		System.out.print("Max Heap: ");
		display(maxheap);
		
		System.out.print("\nMin Heap: ");
		display(minheap);
		
		System.out.println("\nMaximum value in the Heap: "+getMax());
		
		System.out.println("Minimum value in the Heap: "+getMin());
		
	}

}
