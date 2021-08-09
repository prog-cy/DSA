package recursion;

public class DisplayNumberFrom {
	
	//method to print number from 1 to n
	static void show1ToN(int n) {
		
		if(n == 0) return;
		show1ToN(n-1);
		System.out.print(n+" ");
	}
	
	//method to print number from n to 1
	static void showNTo1(int n) {
		
		if(n == 0)return;
		System.out.print(n+" ");
		showNTo1(n-1);
	}
	
	//main method
	public static void main(String[] args) {
		
		System.out.println("Numbers from 1 to 5");
		show1ToN(5);
		System.out.println();
		System.out.println("Number from 5 to 1");
		showNTo1(5);
	}

}
