package recursion;

public class PrimeFactor {
	
	//method to print prime factor of a number by recursive approach
	static void prfactor(int n) {
		
		int i = 2;
		
		if(n == 1)return;
		
		while(n%i != 0)
			i++;
		System.out.print(i+" x ");
		prfactor(n/i);
	}
	
	
	//method to print the prime factor of a number by iterative approach
	static void pifactor(int n) {
		
		while(n > 1) {
			
			int i = 2;
			
			while(n%i != 0)
				i++;
			System.out.print(i+" x ");
			n = n/i;
		}
	}
	
	//main method 
	public static void main(String[] args) {
		
		prfactor(72);
		System.out.print("\b\b = "+72);
		System.out.println();
		pifactor(72);
		System.out.println("\b\b = "+72);
	}

}
