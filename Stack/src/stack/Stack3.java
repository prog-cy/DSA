package stack;

//Implementing stack using Built-in class Stack in java.
import java.util.*;

public class Stack3 {
	
	public static void main(String[] args) {
		
		//Built-in Stack class in java to work with stack defined in java.util.* package
		Stack<String> stack = new Stack<>();
		
		System.out.println("stack is empty: "+stack.empty());
		//adding data in the stack 
		stack.push("Rupesh");
		stack.push("Rohan");
		stack.push("Ratan");
		stack.push("Radhika");
		
		System.out.println("Data present in the stack");
		System.out.println(stack);
		for(String name : stack) {
			System.out.println(name);
		}
		System.out.println("stack is empty: "+stack.empty());
		System.out.println("popped element is : "+stack.pop());
		System.out.println("Peek of stack: "+stack.peek());
		
		//contains method check that particular element present in the stack or not
		if(stack.contains("Ratan"))
			System.out.println("Ratan is present in the stack");
		
		System.out.println("Rohan is present at position "+stack.search("Rohan")+" in the stack.");
	
	}

}
