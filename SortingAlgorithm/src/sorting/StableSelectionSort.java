package sorting;

//In this program I have  implemented stable selection  sort 
// Stable sorting algorithm are those sorting algorithm which preserved the relative ordering of 
// duplicate elements.

public class StableSelectionSort {
	
	static void stableSelectionSort(int[] arr) {
		
		int n = arr.length;
		
		for(int i = 0; i<n-1; i++) {
			
			int min = i;
			
			for(int j = i+1; j<n; j++) {
				
				if(arr[min] > arr[j])
					min = j;
			}
			
			int key = arr[min];
			
			//this below logic is for shifting the elements in array
			while(i<min) {
				
				arr[min] = arr[min-1];
				min--;
			}
			
			arr[i] = key;
		}
	}
	
	//Main method 
	public static void main(String[] args) {
		
		int[] arr = {34, 56, 50, 50, -10, -10, 34, 56, 78};
		
		stableSelectionSort(arr);
		
		System.out.println(java.util.Arrays.toString(arr));
	}
}
