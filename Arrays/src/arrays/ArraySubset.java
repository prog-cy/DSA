package arrays;

// In this program we are finding the subset of the array 

public class ArraySubset {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3};
		
		int n = arr.length;
		
		for(int i = 1; i<(1<<n); i++) { // Here (1<<n) represents 2^n
			
			System.out.print("{ ");
			
			for(int j = 0; j<n; j++) {
				
				if((i&(1<<j)) > 0)
					System.out.print(arr[j]+" ");
			}
			
			System.out.println("}");
		}
	}

}
