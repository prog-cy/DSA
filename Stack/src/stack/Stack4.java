package stack;

//application of stack infix to postfix conversion

public class Stack4 {
	
	int top;
	private char[] stack = new char[40];
	
	//constructor to initialize the top
	Stack4() {
		top = -1;
	}
	
	//method to push into the stack
	void push(char ch) {
		if(top >= stack.length-1) {
			System.out.println("Overflow");
			return;
		}
		stack[++top] = ch;
	}
	
	//method to pop the character from the stack
	char pop() {
		if(isEmpty()) {
			return '!';
		}
		else {
			return stack[top--];
		}
	}
	
	//method to return the peek
	char peek() {
		
		if(isEmpty())return '!';
		return stack[top];
	}
	//method to check that stack is empty or not
	boolean isEmpty() {
		
		return (top<0);
	}
	
	//this method is to find the precedence of the operator
	static int prec(char c) {
		
		int set = -1;
		switch(c) {
		case '^':
				set = 3;
				break;
		case '*':
		case '/':
		case '%':
				set = 2;
				break;
		case '+':
		case '-':
				set = 1;
				break;
		default:
			break;
		}
		return set;
	}
	
	//method to convert infix to postfix expression
	String infixToPostfix(String exp) {
		
		String postfix = "";
		
		for(int i = 0; i<exp.length(); i++) {
			
			char c = exp.charAt(i);
			
			if(Character.isLetterOrDigit(c))
				postfix += c;
			
			else if(c == '(')
				push(c);
			
			else if(c == ')'){
				while(!isEmpty() && peek() != '(') {
					postfix += pop();
				}
				pop();
			}
	
			else{
				
				while(!isEmpty() && prec(peek()) >= prec(c))
				{
					postfix += pop();
				}
				push(c);
			}
			
			
				
		}
		
		while(!isEmpty()) {
			if(peek() == '(')
				return "Invalid expression";
			postfix += pop();
		}
		
		
		return postfix;
	}
	//main method
	public static void main(String[] args) {
		
		Stack4 stk1 = new Stack4();
		String infix = "1+(2+4)+7*6/4";
		String postfix = stk1.infixToPostfix(infix);
		System.out.println(infix+" expression postfix : "+postfix);
		int result = new PostFixEval().eval(postfix);
		System.out.println("Value of the expression "+postfix+" := "+result);
	}

}
