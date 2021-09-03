package sorting;

import java.util.Arrays;

//Time complexity in best case O(nlogn)
//Time complexity in worst case O(n^2)
public class QuickSort {
	
	//method for quick sort
	static void quickSort(int[] arr, int low, int up) {
		
		int pivloc;
		
		if(low > up)
			return;
		pivloc = partition(arr, low, up);
		quickSort(arr, low, pivloc-1);
		quickSort(arr, pivloc+1, up);
		
	}
	
	//method for partitioning
	static int partition(int[] arr, int low, int up) {
		
		int i = low+1;
		int j = up;
		int pivot = arr[low];
		
		while(i <= j) {
			
			while(arr[i] < pivot && i<up)
				i++;
			
			while(arr[j] > pivot)
				j--;
			
			if(i<j) {
				
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			else
				i++;
			
		}
		
		arr[low] = arr[j];
		arr[j] = pivot;
		
		return j;
	}
	
	//main method
	public static void main(String[] args) {
		
	int[] arr = {10, 5, 6, 20, 24, 78, 90, 12, 1, 23};
		
		System.out.println("Array before sorting: "+Arrays.toString(arr));
		
		quickSort(arr, 0, arr.length - 1);
		
		System.out.println("Array after sorting: "+Arrays.toString(arr));
	}
}
