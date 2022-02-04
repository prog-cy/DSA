package sorting;

// Time complexity of this algorithm is O(n)
// It is not a In-place sort
// It is stable sort.

public class CountingSort {
	
	//This method is used to find the minimum and maximum in given array
	public static int[] MinOrMax(int[] arr) {
		
		int[] ans = new int[2];
		ans[0] = arr[0];
		ans[1] = arr[0];
		
		for(int i = 1; i<arr.length; i++) {
			
			ans[0] = ans[0] > arr[i] ? arr[i] : ans[0];
			ans[1] = ans[1] < arr[i] ? arr[i] : ans[1];
		}
		
		return ans;
	}
	
	//Implementation of countSort method
	public static void countSort(int[] arr) {
		
		int min = MinOrMax(arr)[0];
		int max = MinOrMax(arr)[1];
		
		int[] farr = new int[max-min+1];
		//This is frequency array which contains the frequency of each element of the given array
		
		for(int i = 0; i<arr.length; i++) {
			
			farr[arr[i]-min]++;
		}
		
		//Now I have made the prefix sum frequency array
		for(int i = 1; i<farr.length; i++) {
			
			farr[i] = farr[i-1]+farr[i];
		}
		
		int[] ans = new int[arr.length];
		
		for(int i = arr.length-1; i>=0; i--) {
			
			ans[farr[arr[i]-min]-1] = arr[i];
			farr[arr[i]-min]--;	
		}
		
		System.arraycopy(ans, 0, arr, 0, arr.length);
	}
	
	//method is used to display the array
	public static String display(int[] arr) {
		
		if(arr == null)
			return "null";
		
		int iMax = arr.length-1;
		if(iMax == -1)
			return "{}";
		StringBuilder b = new StringBuilder();
		b.append("{");
		for(int i = 0; ; i++) {
			
			b.append(arr[i]);
			if(i == iMax)
				return b.append("}").toString();
			b.append(", ");
		}
	}
	
	//main method
	public static void main(String[] args) {
		
		int[] intArray = {2, 5, 3, 8,  9, 7, 6, 4, 3, 2, 9, 10, 3, 4, 6, 3, 4, 5, 6, 2, 3, 4, 3};
		
		countSort(intArray);
		
		System.out.println(display(intArray));
		
	}

}
