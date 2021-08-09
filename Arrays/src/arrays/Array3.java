package arrays;

public class Array3 {

	public static void main(String[] args) {
		
		//jagged array in java
		int[][] arr = new int[3][];
		
		for(int i = 0; i<arr.length; i++) {
			arr[i] = new int[i+1];
			for(int j = 0; j<arr[i].length; j++)
				arr[i][j] = 2*i+1;
		}
		
		//traversing the array
		System.out.println("Elements in jagged array ");
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
		
		int[][] jarr  = new int[3][];
		
		jarr[0] = new int[3];
		jarr[1] = new int[2];
		jarr[2] = new int[5];
		
		int count = 0;
		
		for(int i = 0; i<jarr.length; i++) {
			for(int j = 0; j<jarr[i].length; j++)
				jarr[i][j] = ++count;
		}
		
		System.out.println("\nTraversing again ");
		for(int i = 0; i<jarr.length; i++) {
			for(int j = 0; j<jarr[i].length; j++)
				System.out.print(jarr[i][j]+" ");
			System.out.println();
		}
		

	}

}
