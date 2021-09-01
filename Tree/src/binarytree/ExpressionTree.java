package binarytree;
import java.util.Stack;

//In this class I am going to create expression tree of infix expression

public class ExpressionTree {
	
	static class Node{
		
		char data;
		Node left, right;
		
		Node(char data){this.data = data;}
	}
	
	//method to check precedence of the operator
	static int prec(char c) {
		
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
		default:
			break;
		}
		
		return -1;
	}
	
	//method to convert infix to postfix
	static String infixToPostfix(String exp) {
		
		Stack<Character> stack = new Stack<>();
		
		String postfix = "";
		for(int i = 0; i<exp.length(); i++) {
			
			Character c = exp.charAt(i);
			
			if(Character.isLetterOrDigit(c))
				postfix += c;
			
			else if(c == '(')
				stack.push(c);
			
			else if(c == ')') {
				
				while(!stack.empty() && stack.peek() != '(') {
					
					postfix += stack.pop();
				}
				stack.pop();
				
			}
			else {
				
				if(!stack.empty() && prec(stack.peek()) >= prec(c))
					postfix += stack.pop();
				stack.push(c);
			}
		}
		
		while(!stack.empty()) {
			
			if(stack.peek() == '(')
				return "Invalid expression";
			postfix += stack.pop();
		}
		return postfix;
	}
	
	//method to create expression tree
	static Node expressionTree(String exp) {
		
		Stack<Node> stack = new Stack<>();
		
		String postfix = infixToPostfix(exp);
		
		Node root = null;
		
		for(int i = 0; i<postfix.length(); i++) {
			
			Character c = postfix.charAt(i);
			
			if(Character.isLetterOrDigit(c)) {
				root = new Node(c);
				stack.push(root);	
			}
			else {
				
				root = new Node(c);
				
				root.right = stack.pop();
				root.left = stack.pop();
				
				stack.push(root);
				
			}
		}
		
		root = stack.pop();
		return root;
	}
	
	//getting postfix expression from expression tree
	static String postfix = "";
	static String postfix(Node root) {
		
		if(root == null)return "";
		
		postfix(root.left);
		postfix(root.right);
		
		postfix += root.data;
		
		return postfix;
	}
	
	//getting infix expression from expression tree
	static String infix = "";
	static String infix(Node root) {
		
		if(root == null)return "";
		
		infix(root.left);
		infix += root.data;
		infix(root.right);
		
		return infix;
	}
	
	
	//main method
	public static void main(String[] args) {
		
		String exp = "a+b-(c*d/e)*f/g+h";
		
		System.out.println("Postfix: "+infixToPostfix(exp));
		Node root = expressionTree(exp);
		
		System.out.println("Postfix: "+postfix(root));
		
		System.out.println("Infix: "+infix(root));

	}

}

 