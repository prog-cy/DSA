package stack;

import java.io.*;
import java.util.*;

public class ReverseString {
	
	Stack<Character> stack = new Stack<>();
	
	String reverse(String str) {
		
		String rev = "";
		
		for(int i = 0; i<str.length(); i++)
			stack.push(str.charAt(i));
		
		while(!stack.empty())
			rev += stack.pop();
		return rev;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the string: ");
		String s = br.readLine();
		
		System.out.println("Original string: "+s);
		System.out.println("Reverse string: "+new ReverseString().reverse(s));
		
	}

}
