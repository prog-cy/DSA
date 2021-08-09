package recursion;

import java.util.Scanner;

public class SumOfDigitsOfANumber {
	
	//method to calculate the sum of digits of a given number
	static int digitsum(int n) {
		
		if(n == 0)return 0;
		return n%10 + digitsum(n/10);
	}
	
	//method to display the  digits of a number
	static void display(int n) {
		
		if(n == 0)return;
		System.out.print(n%10+" + ");
		display(n/10);
		
		
	}
	//main method
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the integer number: ");
		
		int n = sc.nextInt();
		int result = digitsum(n);
		display(n);
		System.out.print("\b\b = "+result);
		
		
		sc.close();
	}

}
