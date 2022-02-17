package sorting;

import java.util.*;

//Heap sort without heapify approach it takes more time than heapify approach but it is simple
// and in this approach I have done exactly same what we do in real heap sort using pen and paper

public class HeapSortWithoutHeapify {
	
	static ArrayList<Integer> heap = new ArrayList<>();
	
	//method to insert in the heap
	static void insert(int key) {
		
		heap.add(key);
		
		int i = heap.size() - 1;
		
		while(i > 0) {
			
			int parent = (i-1)/2;
			
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
	
		int del = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		
		int i = 0;
		while(i<(heap.size()-1)/2) {
			
            int max = heap.get(2*i+1) > heap.get(2*i + 2) ? 2*i+1: (2*i+2);
			
            if(heap.get(i) < heap.get(max)) {
            	int temp = heap.get(i);
            	heap.set(i, heap.get(max));
            	heap.set(max, temp);
            
            	i = max;
            }
            else
            	break;
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
		while(i>=0){
			
			arr[i] = delete();
			i--;
		}
	}
	
	//main method
	public static void main(String[] args) {
		
        int[] arr = {10, 5, 6, 20, 24, -9, 78, 90,-10, 12, 1, 23};
        
        System.out.println("Array before sorting: "+Arrays.toString(arr));
        
		heapSort(arr);
		
		System.out.println("Array after sorting: "+Arrays.toString(arr));
	
	}

}
