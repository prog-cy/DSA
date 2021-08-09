package stack;

//Postfix evaluation using stack

public class PostFixEval {
	
	//creating a stack for pushing operand of postfix.
	private int  top = -1;
	private int[] stack = new int[40];
	
	//method to evaluate the postfix expression
	public int eval(String postfix) {
		
		if(postfix.equals("Invalid expression")) {
			return -1;
		}
		
		int result = 0;
		
		for(int i = 0; i<postfix.length(); i++) {
			
			char c = postfix.charAt(i);
			
			if(Character.isDigit(c))
				push(c-'0');
			else {
				
				int num1 = pop();
				int num2 = pop();
				push(calc(c, num1, num2));
			}
		}
		result = pop();
		return result;
	}
	
	//method to calculating the value 
	int calc(char c, int a, int b) {
		
		int result = 0;
		switch(c) {
		case '+':
			result = b + a;
			break;
		case '-':
			result = b - a;
			break;
		case '*':
			result = b * a;
			break;
		case '/':
			result = b/a;
			break;
		case '%':
			result = b%a;
			break;
		case '^':
			result = (int)Math.pow(b, a);
			break;
		}
		
		return result;
	}
	//method to push the value into the stack
	void push(int data) {
		if(top >= stack.length-1)
			System.out.println("Overflow");
		else {
			stack[++top] = data;
		}
	}
	
	//method to pop the data from the stack
	int pop() {
		
		if(top<0) {
			System.out.println("Underflow");
			return -1;
		}
		else {
			return stack[top--];
		}
	}
}
