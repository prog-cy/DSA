package arrays;

import java.io.*;

//time complexity O(n) and space complexity O(d) of this method for rotating array

public class ArrayRotation {
	
	static int[] tempArray(int[] arr, int d) {
		
		int[] temp = new int[d];
		
		for(int i = 0; i<d; i++)
			temp[i] = arr[i];
		return temp;
	}
	
	static void shiftArray(int[] arr, int n, int d) {
		
		for(int i = 0; i<n-d; i++) {
			arr[i] = arr[d+i];
 		}
	}
	
	static void mergeArray(int[] arr, int[] temp, int n, int d) {
		
		for(int i = n-d; i<n; i++)
			arr[i] = temp[i-(d+1)];
	}
	
	static void printArray(int[] arr) {
		
		for(int x : arr)
			System.out.print(x+" ");
		System.out.println();
	}

	public static void main(String[] args) throws IOException{
		
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(input);
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			
			String[] s = br.readLine().split("\\s");
			int n = Integer.parseInt(s[0]);
			int d = Integer.parseInt(s[1]);
			
			
			int[] arr = new int[n];
			
			String[] array = br.readLine().split("\\s");
			for(int i = 0; i<array.length; i++)
				arr[i] = Integer.parseInt(array[i]);
			
			int[] temp = tempArray(arr, d);
			shiftArray(arr, n, d);
			mergeArray(arr, temp, n, d);
			printArray(arr);
			
		}
	}

}
