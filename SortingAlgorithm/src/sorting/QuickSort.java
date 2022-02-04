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
		
		int i = low+1;
		int j = up;
		int pivot = arr[low];
		
		while(i <= j) {
			
			while(arr[i]<pivot && i<up)
				i++;
			
			while(arr[j]>pivot)
				j--;
			
			if(i<j) {
				
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
			else
				i++;
			
		}
		
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
		
		int[] arr = {10, 5, 6, 20, 24, 78, 90, 12, 1, 23};
		
		System.out.println("Array before sorting: "+printArray(arr));
		
		quickSort(arr, 0, arr.length - 1);
		
		System.out.println("Array after sorting: "+printArray(arr));
	}
}
