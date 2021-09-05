package sorting;

import java.util.*;


public class HeapSort {
	
	static ArrayList<Integer> heap = new ArrayList<>();
	
	//method to insert in the heap
	static void insert(int key) {
		
		heap.add(key);
		
		int i = heap.size() - 1;
		
		while(i > 1) {
			
			int parent = i/2;
			
			if(heap.get(parent) < heap.get(i)){
				
				int temp = heap.get(parent);
				heap.set(parent, heap.get(i));
				heap.set(i, temp);
			}
			
			i = parent;
		}
	}
	
	//method to delete the element from the heap
	static int delete() {
		
		int del = heap.get(1);
		heap.set(1, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		
		int i = 1;
		while(i<heap.size()/2) {
			
            int max = heap.get(2*i) > heap.get(2*i + 1) ? 2*i : ((2*i)+1);
			
			int temp = heap.get(i);
			heap.set(i, heap.get(max));
			heap.set(max, temp);
			
			i++;
		}
		
		return del;
		
	}
	
	//method to create the heap for the given array
	static void createHeap(int[] arr) {
		
		for(int x : arr)
			insert(x);
	}
	
	//method for heap sort
	static void heapSort(int[] arr) {
		
		createHeap(arr);
		int i = arr.length - 1;
		while(heap.size() != 1){
			
			arr[i] = delete();
			i--;
		}
	}
	
	//main method
	public static void main(String[] args) {
		
		heap.add(Integer.MIN_VALUE);
		
        int[] arr = {10, 5, 6, 20, 24, 78, 90, 12, 1, 23};
		
        System.out.println("Array before sorting: "+Arrays.toString(arr));
        
		heapSort(arr);
		
		System.out.println("Array after sorting: "+Arrays.toString(arr));
	
	}

}
