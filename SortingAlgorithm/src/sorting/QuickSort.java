package sorting;


//Time complexity in best case O(nlogn)
//Time complexity in worst case O(n^2)

public class QuickSort {
	
	//method for quick sort
	static void quickSort(int[] arr, int low, int up) {
		
		if(low > up)
			return;
		
		int pivloc = partition(arr, low, up);
		quickSort(arr, low, pivloc-1);
		quickSort(arr, pivloc+1, up);
		
	}
	
	//method for partitioning
	static int partition(int[] arr, int low, int up) {
		
		int pivot = arr[low];
		
		int i = low+1, j = up;
		
		//This i<=j condition handles when there are only two elements in the array.
		while(i <= j) {
			
			//This while loop takes care of all three corner cases
			//Case-1: When all the elements in the array are equal
			//Case-2: When all the elements are smaller than the pivot.
			//Case-3: When some elements are smaller and some elements are equal.
			while(i<=up && arr[i]<=pivot) 
				i++;
			
			//This is for when all elements are greater than pivot.
			while(arr[j]>pivot)
				j--;
			
			//This swapping is for when ith element is greater and jth is smaller.
			if(i<j) {
				
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}

			
		}
		
		//These two lines are responsible for putting the pivot to its right index.
		arr[low] = arr[j];
		arr[j] = pivot;
		
		return j;
	}
	
	public static String printArray(int[] arr) {
		
		if(arr == null)
			return "null";
		int iMax = arr.length-1;
		if(iMax == -1)
			return "{}";
		StringBuilder b = new StringBuilder();
		b.append("{");
		for(int i = 0; ; i++){
			
			b.append(arr[i]);
			if(i == iMax)
				 return b.append("}").toString();
			b.append(", ");
			
		}
	}
	
	//main method
	public static void main(String[] args) {
		
		int[] arr = {7, 3, 8, 6, 12, 10, 9, 8, 7, 6, 3};
		
		System.out.println("Array before sorting: "+printArray(arr));
		
		quickSort(arr, 0, arr.length - 1);
		
		System.out.println("Array after sorting: "+printArray(arr));
	}
}
