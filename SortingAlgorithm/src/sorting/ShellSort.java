package sorting;

import java.util.Arrays;

//I am going to implement Shell sort 
//Time complexity  of this algorithm is O(n^1.25) and for some sequence it is O(n*(logn)^2)

public class ShellSort {
	
	//method for shell sort
	static void shellSort(int[] arr) {
		
		int i, j;
		
		int h = arr.length/2;  
		
		while(h >= 1) {
			
			for(i = h; i<arr.length; i++) {
				
				int k = arr[i];
				
				for(j = i - h; j >= 0 && k<arr[j]; j = j - h)
					arr[j+h] = arr[j];
				arr[j+h] = k;
			}
			
			h /= 2;
		}
	}
	
	//main method
	public static void main(String[] args) {
		
		int[] arr = {10, 5, 6, 20, 24, 78, 90, 12, 1, 23};
			
		System.out.println("Array before sorting: "+Arrays.toString(arr));
		
		shellSort(arr);
		
		System.out.println("Array after sorting: "+Arrays.toString(arr));
	}
}
