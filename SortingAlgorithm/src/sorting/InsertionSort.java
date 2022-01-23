package sorting;

import java.util.Arrays;


//Time complexity of this algorithm is O(n^2).
// It is In-Place sort
// It is stable-sort

public class InsertionSort {
	
	static void insertionSort(int[] arr) {
		
		int i, j;
		
		for(i = 1; i<arr.length; i++) {
			
			int k = arr[i];
			
			for(j = i-1; j>=0 && k<arr[j]; j--)
				arr[j+1] = arr[j];
			arr[j+1] = k;
		}
	}
	//main method
	public static void main(String[] args) {
		
		int[] arr = {40, 30, 10, -45, 34, 560, 90, 100, 345, 300};
		
		System.out.println("Array before sorting: "+Arrays.toString(arr));
		
		insertionSort(arr);
		
		System.out.println("Array after sorting: "+Arrays.toString(arr)); 
	}

}
