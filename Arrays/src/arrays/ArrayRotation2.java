package arrays;

//By juggling algorithm time complexity O(n)

public class ArrayRotation2 {
	
	static int gcd(int a, int b) {
		
		if(b == 0) return a;
		return gcd(b, a%b);
	}
	
	static void leftRotate(int[] arr, int n, int d) {
		
		d = d%n;
		int j, k, t;
		int g_c_d = gcd(n ,d);
		
		for(int i = 0; i<g_c_d; i++) {
			
			t = arr[i];
			j = i;
			
			while(true) {
				k = j+d;
				
				if(k>=n)
					k = k-n;
				if(k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = t;
		}
	}
	
	void printArray(int[] arr) {
		for(int x : arr)
			System.out.print(x+" ");
		System.out.println();
	}

	public static void main(String[] args) {
		
		ArrayRotation2 ob = new ArrayRotation2();
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		
		leftRotate(arr, 7, 2);
		ob.printArray(arr);

	}

}
