package recursion;

public class DisplayNumberWithSummation {
	
	//method to perform this task
	static int dsum(int n) {
		if(n == 0)return 0;
		int result =  n + dsum(n-1);
		System.out.printf("%d + ", n);
		return result;
	}
	
	//main method
	public static void main(String[] args) {
		
		System.out.printf("= %d", dsum(10));
	}

}
