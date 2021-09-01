package sorting;

import java.util.Arrays;

//In this class I am going to implement the selection sort algorithm
//Time complexity of Selection sort is O(n^2). 

public class SelectionSort {
	
	//method to swap two values in the array
	static void swap(int[] arr, int index1, int index2) {
		
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	//method for selection sort
	static void selectionSort(int[] arr) {
		
		int i, j;
		for(i = 0; i<arr.length-1; i++) {
			
			int min = i;
			
			for(j = i+1; j<arr.length; j++) {
				
				if(arr[min] > arr[j])
					min = j;
			}
			
			if(i != min) {
				
				swap(arr, min, i);
			}
		}
	}
	
	//main method
	public static void main(String[] args) {
		
		int[] arr = {10, 5, 6, 20, 24, 78, 90, 12, 1, 23};
		
		System.out.println("Arrays before sorting: "+Arrays.toString(arr));
		
		selectionSort(arr);
		
		System.out.println("Arrays after sorting: "+Arrays.toString(arr));
	}

}
