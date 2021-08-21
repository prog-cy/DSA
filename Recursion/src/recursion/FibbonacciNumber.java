package recursion;

public class FibbonacciNumber {
	
	//method to find the fibonacci series
	static int fib(int n) {
		
		if(n == 0 || n == 1)return 1;
		
		return fib(n-1) + fib(n-2);
	}
	
	//main method
	public static void main(String[] args) {
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		System.out.println("Enter how many terms of fibonacci series you want: ");
		int n = sc.nextInt();
		sc.close();
		
		System.out.println("Fibonacci series having "+n+" terms");
		
		for(int i = 0; i<n; i++){
			System.out.print(fib(i)+" ");
		}
	}

}
