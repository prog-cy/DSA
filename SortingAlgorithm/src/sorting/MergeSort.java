package sorting;

import java.util.Arrays;

//Time complexity of Merge sort algorithm is O(nlogn)

public class MergeSort {
	
	//merging the two array 
	static void merge(int[] arr,int[] temp, int low1, int up1, int low2, int up2) {
		
		int i = low1, j = low2, k = low1;
		
		while(i<=up1 && j<=up2) {
			
			temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
		}
		
		while(i<=up1)
			temp[k++] = arr[i++];
		while(j<=up2)
			temp[k++] = arr[j++];
	
	}
	
	//method to copy the one array into another 
	static void copy(int[] arr, int[] temp, int low, int up) {
		
		for(int i = low; i<=up; i++)
			arr[i] = temp[i];
	}
	
	//method for merge sort
	static void mergeSort(int[] arr, int low, int up) {
		
		int[] temp = new int[arr.length];
		
		if(low < up) {
			
			int mid = (low + up)/2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, up);
			merge(arr, temp, low, mid, mid+1, up);
			copy(arr, temp, low, up);
		}
	}
	
	//main method
	public static void main(String[] args) {
		
		int[] arr = {10, 5, 6, 20, 24, 78, 90, 12, 1, 23, -20};
		
		System.out.println("Array before sorting: "+Arrays.toString(arr));
		
		mergeSort(arr, 0, arr.length - 1);
		
		System.out.println("Array after sorting: "+Arrays.toString(arr));
	}
}
