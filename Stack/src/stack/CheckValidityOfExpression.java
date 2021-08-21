package stack;
import java.io.*;
import java.util.*;


public class CheckValidityOfExpression {
	
	Stack<Character> stack = new Stack<>();
	
	boolean match(char a, char b) {
		
		if((a == '[') && (b == ']'))
			return true;
		else if((a == '{') && (b == '}'))
			return true;
		else if((a == '(') && (b == ')'))
			return true;
		return false;
	}
	
	boolean checkValidity(String exp) {
		
		for(int i = 0; i<exp.length(); i++) {
			
			Character ch = exp.charAt(i);
			
			if((ch == '(') || (ch == '{') || (ch == '['))
				stack.push(ch);
			if((ch == ')') || (ch == '}') || (ch == ']')) {
				
				if(stack.empty())
					return false;
				else {
					
					char temp = stack.pop();
					
					if(!match(temp, ch))
						return false;	
				}
			}
		}
		
		if(stack.empty())
			return true;
		else
			return false;
	
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter expression: ");
		String exp = br.readLine();
		
		if(new CheckValidityOfExpression().checkValidity(exp))
			System.out.println(exp+" is valid.");
		else
			System.out.println(exp+" is not valid.");
		
	}

}
