 package heap;

import java.util.Arrays;

public class MaxHeapOfArray {
	
	static void swap(int[] a, int i, int j) {
		
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void heapify(int[] a, int n, int i) {
		
		int largest = i;
		int l = 2*i+1;
		int r = 2*i+2;
		
		largest = (l<n && a[largest] < a[l]) ? l : largest;
		
		largest = (r<n && a[largest] < a[r]) ? r : largest;
		
		if(largest != i) {
			
			swap(a, largest, i);
			heapify(a, n, largest);
		}
		
	}
	
	static void buildMaxHeap(int[] arr) {
		
		int n = arr.length;
		
		for(int i = (n/2)-1; i>=0; i--)
			heapify(arr, n, i);
	}
	
	public static void main(String[] args) {
		
		int[] arr = {5, 3, 10, 20, 30, 100, 50, 89};
		
		System.out.println("Array Before building the heap: "+ Arrays.toString(arr));
		
		buildMaxHeap(arr);
		
		System.out.println("Array After building the heap: "+Arrays.toString(arr));
		
		
	}

}
