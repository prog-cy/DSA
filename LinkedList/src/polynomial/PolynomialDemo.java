package polynomial;

//In this program I am creating a polynomal using singly linked list

public class PolynomialDemo {
	
	static class Node{
		
		int data;
		int pow;
		Node next;
		
		Node(int data, int pow){
			
			this.data = data;
			this.pow = pow;
			
		}
	}
	
	static Node head;
	static Node tail = null;
	
	static void createPolynomialTerm(int data, int pow) {
		
		Node term = new Node(data, pow);
		
		if(head == null) {
			
			head = term;
			tail = term;
		}
		else {
			
			tail.next = term;
			tail = term;
		}
	}
	
	//method to print the polynomial
	static void display() {
		
		Node temp = head;
		if(temp == null) return;
		while(temp != null) {
			
			System.out.print(temp.data+"x^"+temp.pow+" + ");
			
			temp = temp.next;
			
			if(temp.pow == 0) {
				System.out.print(temp.data+" ");
				return;
			}
		}
	}
	
	//main method
	public static void main(String[] args) {
		
		head = null;
		createPolynomialTerm(3, 2);
		createPolynomialTerm(2, 1);
		createPolynomialTerm(1, 0);
		
		System.out.print("Quadratic Polynomial: ");
		display();
		
		head = null;
		createPolynomialTerm(5, 3);
		createPolynomialTerm(10, 2);
		createPolynomialTerm(-9, 1);
		createPolynomialTerm(20, 0);
		
		System.out.print("\nCubic Polynomial: ");
		display();
		
		head = null;
		createPolynomialTerm(10, 4);
		createPolynomialTerm(5, 3);
		createPolynomialTerm(45, 0);
		
		System.out.print("\n4th power Polynomial: ");
		display();
	}

}
