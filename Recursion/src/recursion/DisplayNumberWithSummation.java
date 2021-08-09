package recursion;

//In this program we have to add n natural number and also we have to show the number in series form.

public class DisplayNumberWithSummation {
	
	//method to perform this task
	static int dsum(int n) {
		if(n == 0)return 0;
		int result =  n + dsum(n-1);
		System.out.print(n+" + ");
		return result;
	}
	
	//main method
	public static void main(String[] args) {
		
		System.out.printf("\b\b = "+dsum(10));
	}

}
