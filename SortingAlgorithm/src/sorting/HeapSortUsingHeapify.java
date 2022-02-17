package sorting;

import java.util.Arrays;

//HeapSort in O(n*log2^n) 

public class HeapSortUsingHeapify {
	
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
		
		for(int i = (n/2)-1; i>=0; i--) {
			
			heapify(arr, n, i);
		}
	}
	
	static void heapSort(int[] arr) {
		
		buildMaxHeap(arr);
		
		int n = arr.length;
		
		for(int i = n-1; i>0; i--) {
			
			swap(arr, 0, i);
			heapify(arr, i, 0);
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {5, 6, 10, 3, 100, 23, 11, 99};
		
		System.out.println(Arrays.toString(arr));
		
		heapSort(arr);
		
		System.out.println(Arrays.toString(arr));
		
	}

}
