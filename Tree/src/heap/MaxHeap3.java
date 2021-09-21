package heap;

import java.util.ArrayList;

//deletion from the heap

public class MaxHeap3 {
	
	static ArrayList<Integer> heap = new ArrayList<>();
	
	//method to insert in the heap
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
	
	//method to delete from the heap
	static void delete() {
		
		System.out.println("\n"+heap.get(1) + " deleted");
		heap.set(1, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		
		int i = 1;
		
		while(i < heap.size()/2){
			
			int max = heap.get(2*i) > heap.get(2*i + 1) ? 2*i : (2*i+1);
			
			if(heap.get(i) < heap.get(max)) {
				int temp = heap.get(i);
				heap.set(i, heap.get(max));
				heap.set(max, temp);
				i = max;
			}
			else
				break;
		}
	}
	
	//method to display the element of the heap
	static void display() {
		
		for(int i = 1; i<heap.size(); i++)
			System.out.print(heap.get(i)+" ");
	}
	
	//method to get height of the heap
	static int height(int index) {
		
		if(index >= heap.size()) return 0;
		
		return 1 + height(2*index);
	}
	
	//main method
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
		insert(200);
		insert(80);
		
		System.out.println("Height of the heap: "+height(1));
		
		System.out.print("Max Heap: ");
		display();
		
		delete();
		
		System.out.print("Max Heap: ");
		display();
		
		delete();
		
		System.out.print("Max Heap: ");
		display();
		
		delete();
		
		System.out.print("Max Heap: ");
		display();	
		
		
	}
}
