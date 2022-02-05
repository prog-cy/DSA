package arrays;

//static array declaration and initialization 


public class Array1 {


	public static void main(String[] args) {
		
		//declaration of 1-D array and initializing
		int[] arr = {1, 2, 3, 4};
		
		//traversing an array using for-each loop
		System.out.println("Using for-each loop");
		for(int x : arr)
			System.out.print(x+" ");
		
		//traversing using for loop
		System.out.println("\nUsing for loop");
		for(int i = 0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
		
		//declaring 2-D array and initializing 
		int[][] arr1 =  {
						
								{1, 2, 3, 4, 5},
								{3, 4, 5, 6, 7}
						};
		//traversing using for-each loop
		System.out.println("\nUsing for-each loop");
		for(int[] ar : arr1) {
			for(int x : ar)
				System.out.print(x+" ");
			System.out.println();
		}
		
		//declaring 3-D array and initializing
		int[][][] arr3 = {
								{{1, 2}, {3, 4}},
								{{5, 6}, {7, 8}},
								{{6, 7}, {8, 9}}
					};
		//traversing using for-each loop
		System.out.println("\nUsing for-each loop");
		for(int[][] ar : arr3) {
			for(int[] ar1 : ar) {
				for(int x : ar1)
					System.out.print(x+" ");
				System.out.println();
			}
			System.out.println();
		}
		
		//declaring 4-D array and initializing
		int[][][][] arr4 = {
								{{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}}, 
								{{{8, 7}, {6, 5}}, {{4, 3}, {2, 1}}}, 
							};
		//traversing using for-each loop
		System.out.println("\nUsing for-each loop traversing a 4-D array");
		for(int[][][] ar : arr4) {
			for(int[][] a : ar) {
				for(int[] a1 : a) {
					for(int x : a1)
						System.out.print(x+" ");
					System.out.println();
				}
				System.out.println();
			}
			System.out.println();
		}
		
		//declaring 1-D array and using new keyword assign space in the memory
		int[] arr5 = new int[5];
		
		//storing values in the array
		for(int i = 0; i<arr5.length; i++)
			arr5[i] = i+1;
		
		//traversing array using while loop
		System.out.println("\nUsing while loop");
		int i = 0;
		while(i<arr5.length) {
			System.out.print(arr5[i]+" ");
			i++;
		}
		
		//declaring array literal
		int[] arr6 = new int[]{30, 40, 50 ,60, 70};
		
		System.out.println("\nTraversing array: ");
		for(int x : arr6)
			System.out.print(x+" ");
	}

}
