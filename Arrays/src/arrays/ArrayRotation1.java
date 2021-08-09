package arrays;

import java.io.*;
//rotating an array in time complexity O(n*d) and auxiliary space O(1).
public class ArrayRotation1 {
	
	static void leftByOne(int[] arr, int n) {
		
		int t = arr[0];
		for(int i = 0; i<n-1; i++)
			arr[i] = arr[i+1];
		arr[n-1] = t;
	}
	
	static void leftRotate(int[] arr, int d, int n) {
		
		for(int i = 0; i<d; i++)
			leftByOne(arr, n);
	}
	
	static void printArray(int[] arr) {
		
		for(int x : arr)
			System.out.print(x+" ");
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(input);
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			
			String[] s = br.readLine().split("\\s");
			int n = Integer.parseInt(s[0]);
			int d = Integer.parseInt(s[1]);
			
			int[] arr = new int[n];
			
			String[] array = br.readLine().split("\\s");
			
			for(int i = 0; i<n; i++)
				arr[i] = Integer.parseInt(array[i]);
			
			
			leftRotate(arr, d, n);
			printArray(arr);
			
		}

	}

}
