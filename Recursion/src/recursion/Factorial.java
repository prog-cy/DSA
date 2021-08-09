package recursion;

public class Factorial {
	
	//method to calculate the factorial of a number recursively
	static long fact(int n) {
		
		if(n == 1 || n == 0) return 1;
		return n*fact(n-1);
	}
	
	//main method
	public static void main(String[] args) {
		
		long result = fact(5);
		System.out.println("Factorial of 5 is : "+result);
		
		for(int i = 6; i<=20; i++)
			System.out.println("Factorial of "+i+" is: "+fact(i));
		
		
		
	}

}
