package heap;

import java.util.*;

public class MinHeap1 {
	
	static ArrayList<Integer> heap = new ArrayList<>();
	
	static void insert(int key) {
		
		heap.add(key);
		
		int i = heap.size()-1;
		
		while(i>1) {
			
			int parent = i/2;
			
			if(heap.get(parent) > heap.get(i)) {
				
				int temp = heap.get(parent);
				heap.set(parent, heap.get(i));
				heap.set(i, temp);
			}
			
			i = parent;
		}
	}
	
	static void display() {
		
		for(int i = 1; i<heap.size(); i++)
			System.out.print(heap.get(i)+" ");
	}
	
	
	
	public static void main(String[] args) {
		
		
		heap.add(Integer.MIN_VALUE);
		
		insert(5);
		insert(9);
		insert(8);  
		insert(7);
		insert(6);
		insert(10);
		insert(40); 
		insert(90);
		insert(100);
		
		System.out.print("Min Heap: ");
		display();
	}
}
