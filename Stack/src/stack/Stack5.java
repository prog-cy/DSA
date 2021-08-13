package stack;

//Program to convert infix expression to prefix expression
import java.io.*;

public class Stack5 {
	
	private int top;
	private char[] stack = new char[40];
	
	//constructor to initialize the top
	Stack5() {
		top = -1;
	}
	
	//method to push the data into the stack;
	void push(char c) {
		if(top >= stack.length - 1)
			System.out.println("Overflow");
		else
			stack[++top] = c;
	}
	
	//method to pop the data from the stack
	char pop() {
		if(top<0) {
			System.out.println("Underflow");
			return '!';
		}
		else {
			return stack[top--];
		}
	}
	
	//method to return peek value from the stack
	char peek() {
		if(top<0) {
			System.out.println("Underflow");
			return '!';
		}
		else
			return stack[top];
	}
	
	//method to check that stack is empty or not
	boolean isEmpty() {
		return (top<0);
	}
	//method to check precedence of the operators
	int prec(char c) {
		
		switch(c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
		case '%':
			return 2;
		case '^':
			return 3;
		}
		
		return -1;
	}
	
	//method to reverse the infix expression
	String reverse(String str) {
		
		char[] ch = str.toCharArray();
		
		int start = 0;
		int end = ch.length-1;
		
		while(start<end) {
			char temp = ch[start];
			ch[start] = ch[end];
			ch[end] = temp;
			start++;
			end--;
		}
		
		return String.valueOf(ch);
	}
	
	//method to convert infix to prefix expression
	String infixToPrefix(String infix) {
		
		infix = reverse(infix);
		char[] infix1 = infix.toCharArray();
		
		for(int i = 0; i<infix1.length; i++) {
			if(infix1[i] == '(')
				infix1[i] = ')';
			else if(infix1[i] == ')')
				infix1[i] = '(';
		}
		
		infix = String.valueOf(infix1);
		
		String postfix = infixToPostfix(infix);
		String prefix = reverse(postfix);
		
		return prefix;
	}
	
	//method to convert infix to postfix expression
	String infixToPostfix(String infix) { 
		
		String postfix = "";
		
		infix = '(' + infix + ')';
		
		for(int i = 0; i<infix.length(); i++) {
			
			char c = infix.charAt(i);
			
			if(Character.isLetterOrDigit(c))
				  postfix += c;
			else if(c == '(')
				push(c);
			else if(c == ')') {
				while(peek() != '(')
					postfix += pop();
				pop();		
			}    
			else {
				
				while((prec(peek()) > prec(c)) || ((prec(peek()) >= prec(c)) && (c == '^')))
					postfix += pop();
				push(c);
			}
		}
	
		return postfix;
	}
	
	//main method
	public static void main(String[] args) throws IOException{
		
		Stack5 stk1 = new Stack5();
		
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(input);
		
		System.out.println("Enter infix expression");
		String infix = br.readLine();
		
		String postfix = new Stack4().infixToPostfix(infix);
		String prefix = stk1.infixToPrefix(infix);
		System.out.println(infix +" infix expression in prefix expression : "+prefix);
		System.out.println(infix+" infix expression in postfix expression : "+postfix);
		System.out.println(prefix+" prefix expression in infix expression : "+new Stack6().prefixToInfix(prefix));
		System.out.println(postfix+" postfix expression in infix expression : "+new Stack6().postfixToInfix(postfix));
		System.out.println(prefix +" prefix expression in postfix expression : "+new Stack6().prefixToPostfix(prefix));
		System.out.println(postfix + " postfix expression in prefix expression : "+new Stack6().postfixToPrefix(postfix));
		System.out.println("Value of postfix expression " + postfix +" := "+new PostFixEval().eval(postfix));
		System.out.println("Value of prefix expression "  + prefix +"  := "+new PreFixEval().eval(prefix));
	}
}
