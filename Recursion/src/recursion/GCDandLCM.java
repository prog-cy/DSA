package recursion;

public class GCDandLCM {
	
	//method to find the GCD of two number
	static int GCD(int a, int b) {
		
		if(b == 0)return a;
		return GCD(b, a%b);
		
	}
	
	//method to find the LCM of two number
	static int LCM(int a, int b) {
		
		return (a*b)/GCD(a, b);
	}
	
	//main method
	public static void main(String[] args) {
		
		System.out.println("GCD of 14 and 12 is: "+GCD(14, 12));
		System.out.println("LCM of 14 and 12 is: "+LCM(14, 12));
	}

}
