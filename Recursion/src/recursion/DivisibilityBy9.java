package recursion;

public class DivisibilityBy9 {
	
	//method to check Divisibility by 9
	static boolean set;
	static boolean divisibleBy9(long n) {
		
		int sumofdigits;
		if(n == 9) {return true;}
		
		if(n<9) {return false;}
		
		
		sumofdigits = 0;
		
		while(n>0) {
			
			sumofdigits += n%10;
			n = n/10;
		}
		return divisibleBy9(sumofdigits);
	}
	
	//main method
	public static void main(String[] args) {
		
		System.out.println(divisibleBy9(1469358));
	}

}
