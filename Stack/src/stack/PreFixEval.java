package stack;

import java.util.Stack;

//this class is used to evaluate the prefix expression

public class PreFixEval {
	
	Stack<Integer> stack = new Stack<>();
	
	//this method will evaluate the prefix expression
	int eval(String prefix) {
		
		int result = 0;
		
		for(int i = prefix.length()-1; i>=0; i--) {
			
			char c = prefix.charAt(i);
			if(Character.isDigit(c))
				stack.push(c - '0');
			else {
				int num1 = stack.pop();
				int num2 = stack.pop();
				
				result = calc(c, num1, num2);
				stack.push(result);	
			}	
		}
		
		result = stack.pop();
		return result;
	}
	
	//this method is used to find the value when operator is encounter.
	int calc(char c, int a, int b) {
		
		int result = 0;
		
		switch(c) {
		case '+':
			result = a + b;
			break;
		case '-':
			result = a - b;
			break;
		case '*':
			result = a * b;
			break;
		case '/':
			result = a / b;
			break;
		case '%':
			result = a % b;
			break;
		case '^':
			result = (int)Math.pow(a, b);
			break;
		}
		
		return result;
	}
}
