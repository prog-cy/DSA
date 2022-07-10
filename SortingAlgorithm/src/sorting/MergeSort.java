package sorting;

import java.util.Arrays;

//Time complexity of Merge sort algorithm is O(nlogn)

public class MergeSort {
	
	//merging the two array 
	static void merge(int[] arr,int[] temp, int low, int mid, int up) {
		
		int i = low, j = mid+1, k = low;
		
		while(i<=mid && j<=up) {
			
			temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
		}
		
		while(i<=mid)
			temp[k++] = arr[i++];
		while(j<=up)
			temp[k++] = arr[j++];
	
	}
	
	//method to copy the one array into another 
	static void copy(int[] arr, int[] temp, int low, int up) {
		
		for(int i = low; i<=up; i++)
			arr[i] = temp[i];
	}
	
	static boolean tempIsNotCreated = true;
	static int[] temp;
	//method for merge sort
	static void mergeSort(int[] arr, int low, int up) {
		
		if(tempIsNotCreated) {
			temp = new int[arr.length];
			tempIsNotCreated = false;
		}
		
		if(low < up) {
			
			int mid = (low + up)/2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, up);
			merge(arr, temp, low, mid, up);
			copy(arr, temp, low, up);
		}
	}
	
	//main method
	public static void main(String[] args) {
		
		int[] arr = {10, 5, 6, 20, 24, 24, 78, 90, 12, 1, 23, -20};
		
		System.out.println("Array before sorting: "+Arrays.toString(arr));
		
		mergeSort(arr, 0, arr.length - 1);
		
		System.out.println("Array after sorting: "+Arrays.toString(arr));
	}
}
