package stack;

//In this class I am going to convert prefix expression to infix expression and postfix to infix
//and also prefix to postfix , postfix to prefix.
//Below is the implementation of the methods individually.

import java.util.Stack;

public class Stack6 {
	
	Stack<String> stack = new Stack<>(); //Defining the stack using built-in Stack class
	
	//this method is used to convert prefix expression to infix expression
	String prefixToInfix(String prefix) {
		
		int len = prefix.length()-1;
		
		String infix = "";
		
		for(int i = len; i>=0; i--) {
			
			char c = prefix.charAt(i);
			
			if(Character.isLetterOrDigit(c))
				stack.push(c+"");
			else {
				String operand1 = stack.pop();
				String operand2 = stack.pop();
				
				infix = '(' + operand1 + c + operand2 +')';
				
				stack.push(infix);
			}
		}
		return stack.pop();
	}
	
	//method to convert postfix to infix
	String postfixToInfix(String postfix) {
		
		String infix = "";
		
		for(int i = 0; i<postfix.length(); i++) {
			
			char c = postfix.charAt(i);
			
			if(Character.isLetterOrDigit(c))
				stack.push(c +"");
			else {
				String operand1 = stack.pop();
				String operand2 = stack.pop();
				
				infix = '(' + operand2 + c + operand1 +')';
				stack.push(infix);				
			}
		}
		
		infix = stack.pop();
		return infix;	
	}
 
	//method to convert prefix to postfix
	String prefixToPostfix(String prefix) {
		
		String postfix = "";
		
		int len = prefix.length() - 1;
		
		for(int i = len; i>=0; i--) {
			
			char c = prefix.charAt(i);
			
			if(Character.isLetterOrDigit(c))
				stack.push(c+"");
			else {
				
				String operand1 = stack.pop();
				String operand2 = stack.pop();
				
				postfix = operand1 + operand2 + c;
				stack.push(postfix);
			}			
		}
		
		return stack.pop();
	}
	
	//method to convert postfix to prefix
	String postfixToPrefix(String postfix) {
		
		String prefix = "";
		
		for(int i = 0; i<postfix.length(); i++) {
			
			char c = postfix.charAt(i);
			
			if(Character.isLetterOrDigit(c))
				stack.push(c+"");
			else {
				
				String op1 = stack.pop();
				String op2 = stack.pop();
				
				prefix = c + op2 + op1;
				stack.push(prefix);
			}
		}
		
		prefix = stack.peek();
		return prefix;
	}
}
