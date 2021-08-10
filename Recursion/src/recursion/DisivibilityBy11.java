package recursion;

public class DisivibilityBy11 {
	
	//method to check divisibility by 11
	static boolean divisibleby11(int n) {
		
		if(n == 0) return true;
		
		if(n<11) return false;
		
		int s1 = 0;
		int s2 = 0;
	
		while(n>0) {
			
			s1 += n%10;
			n /= 10;
			s2 += n%10;
			n /= 10;
		}
		
		int diff = (s1>s2) ? (s1 - s2) : (s2 - s1);
		return divisibleby11(diff);
	}
	
	//main method 
	public static void main(String[] args) {
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		System.out.println("Enter number which divisibility by 11: ");
		int num = sc.nextInt();
		
		boolean isdivisible = divisibleby11(num);
		
		if(isdivisible)
			System.out.println(num+ " is divisible by 11");
		else
			System.out.println(num + " is not divisible by 11");
		
		sc.close();
    
	}
  
}
