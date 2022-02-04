package sorting;

import java.util.Arrays;

public class RadixSort {
	
	//This is radix sort which uses count sort to sort every single digit of given array
	public static void radixSort(int[] arr) {
		
		int max = arr[0];
		
		for(int val : arr)
			max = val > max ? val : max;
		
		int exp = 1;
		while(exp <= max) {
			
			cntSort(arr, exp);
			exp *= 10;
		}
	}
	
	//This is count sort which is used to sort every single digit of the number given radix sort
	public static void cntSort(int[] arr, int exp) {
		
		int[] farr = new int[10]; //We have created frequency array of size 10 because digit
		//can be in the range of 0-9 only.
		
		int[] ans = new int[arr.length];
		
		for(int i = 0; i<arr.length; i++)
			farr[arr[i]/exp%10]++; //"arr[i]/exp%10" is used to get the proper digit in given number
		
		for(int i = 1; i<farr.length; i++)
			farr[i] = farr[i] + farr[i-1];
		
		for(int i = arr.length-1; i>=0; i--) {
			
			ans[farr[arr[i]/exp%10]-1] = arr[i];
			farr[arr[i]/exp%10]--;
		}
		
		System.arraycopy(ans, 0, arr, 0, arr.length);
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1234, 345, 89, 23, 64387, 457653, 67889};
		
		radixSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}

}
