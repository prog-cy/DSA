package recursion;

public class Exponentiation {
	
	//method to calculate the exponent of a number
	static long power(int base, int exp) {
		
		if(exp == 0)return 1;
		return base * power(base, exp-1);
	}
	
	//main method
	public static void main(String[] args) {
		
		System.out.println("3^4: "+power(3, 4));
	}

}
