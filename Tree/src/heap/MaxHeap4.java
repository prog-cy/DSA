package heap;

import java.util.*;

//Implementing heapify for building a heap from an array 

public class MaxHeap4 {
	
	//this is the dynamic array to create a heap using given data
	static ArrayList<Integer> heap = new ArrayList<>();
	
	//method to insert the data into heap
	static void insert(int key) {
		
		heap.add(key);
		
		int i = heap.size() - 1;
		
		while(i > 1) {
			
			int parent = i/2;
			
			if(heap.get(parent) < heap.get(i)) {
				
				int temp = heap.get(parent);
				
				heap.set(parent, heap.get(i));
				heap.set(i, temp);
			}
			
			i = parent;
		}
	}
	
	//method to display the heap in level order
	static void levelorder() {
		
		for(int i = 1; i<heap.size(); i++)
			System.out.print(heap.get(i)+" ");
	}
	
	// main method
	public static void main(String[] args) {
		
		heap.add(Integer.MIN_VALUE);
		
		insert(10);
		insert(40);
		insert(50);
		insert(809);
		insert(20);
		insert(-10);
		insert(117);
		
		
		System.out.print("Level order traversal of the heap: ");
		levelorder();
	}

}
