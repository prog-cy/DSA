package recursion;

public class SummationOfNaturalNumber {
	
	//method to calculate sum of first n natural number
	static int sum(int n) {
		
		if(n == 1)return 1;
		return n + sum(n-1);
	}
	
	//main method
	public static void main(String[] args) {
		
		int result = sum(5);
		System.out.println("Sum of first 5 natural number: "+result);
		
	}

}
