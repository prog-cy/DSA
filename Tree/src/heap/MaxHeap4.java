package heap;

import java.util.*;

//Implementing heapify for building a heap from an array 

public class MaxHeap4 {
	
	//this is the dynamic array to create a heap using given data
	static ArrayList<Integer> heap = new ArrayList<>();
	
	//method to insert the data into heap
	static void insert(int key) {
		
		heap.add(key);
		
		
		
	}
	
	// main method
	public static void main(String[] args) {
		
		heap.add(Integer.MIN_VALUE);
	}

}
