package recursion;

public class BaseConversion {
	
	//method to convert the base of a number
	static void convert(int num , int base) {
		
		if(num == 0) return;
		convert(num/base, base);
		if(num%base < 10)
			System.out.print(num%base);
		else
			System.out.print((char)(num%base-10 + 'A'));
		
	}
	
	
	//main method
	public static void main(String[] args) {
		
		System.out.print("8 in binary: ");
		convert(8, 2);
		System.out.print("\n8 in octal: ");
		convert(8, 8);
		System.out.print("\n100 in hexadecimal: ");
		convert(1000, 16);
	}

}
