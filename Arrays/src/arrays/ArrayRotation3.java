package arrays;

public class ArrayRotation3 {
	
	static void reverse(int[] arr, int start, int size) {
		
		int l = start;
		int r = size-1;
		
		while(l<r) {
			int t = arr[l];
			arr[l] = arr[r];
			arr[r] = t;
			l++;
			r--;
		}
	}
	
	static void rotate(int[] arr, int d, int n) {
		
		reverse(arr, 0, d);
		reverse(arr, d, n);
		reverse(arr, 0, n);
		
	}
	
	static void printArray(int[] arr) {
		
		for(int x : arr)
			System.out.print(x+" ");
		System.out.println();
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6};
		rotate(arr, 3, 6);
		printArray(arr);
	}

}
