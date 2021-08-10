package recursion;

public class DivisibilityBy9 {
	
	//method to check Divisibility by 9
	static boolean divisibleBy9(long n) {
		
		if(n == 9) {return true;}
		
		if(n < 9) {return false;}
		
		int sumofdigits = 0;
		
		while(n>0) {
			
			sumofdigits += n%10;
			n = n/10;
		}
		return divisibleBy9(sumofdigits);
	}
	
	//main method
	public static void main(String[] args) {
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		System.out.println("Enter number which divisibility you want to check by 9: ");
		int num = sc.nextInt();
		
		boolean isdivisible = divisibleBy9(num);
		
		if(isdivisible)
			System.out.println(num + " is divisible by 9");
		else
			System.out.println(num + " is not divisible by 9");
		sc.close();
		
	}

}
