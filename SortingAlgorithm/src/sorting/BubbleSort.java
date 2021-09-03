package sorting;

import java.util.Arrays;


//Time complexity of this algorithm is O(n^2).

public class BubbleSort {
	
	//method to swap element in the arr
	static void swap(int[] arr, int index1, int index2) {
		
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	//method for bubble sort
	static void bubbleSort(int[] arr) {
		
		int i, j;
		for(i = 0; i<arr.length - 1; i++) {
			
			boolean isSorted = true;
			
			for(j = 0; j<arr.length - 1- i; j++) {
				
				if(arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
					isSorted = false;
				}
			}
			
			if(isSorted)
				break;
		}
	}
	
	//main method
	public static void main(String[] args) {
		
		int[] arr = {10, 5, 6, 20, 24, 78, 90, 12, 1, 23};
		
		System.out.println("Array before sorting: "+Arrays.toString(arr));
		
		bubbleSort(arr);
		
		System.out.println("Array after sorting: "+Arrays.toString(arr));
		
	}
}
