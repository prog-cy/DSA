package polynomial;

//In this class I am going to calculate the sum of the two polynomial

public class SumOfPolynomial {
	
	static class Node{
		
		int data;
		int pow;
		Node next;
		
		Node(int data, int pow){
			this.data = data;
			this.pow = pow;
		}
	}
	
	static Node tail = null;
	
	//method to create the polynomial term 
	static Node createPolynomialTerm(Node head, int data, int pow) {
		
		Node node = new Node(data, pow);
		
		if(head == null) {
			
			head = node;
			tail = node;
		}
		else {
			
			tail.next = node;
			tail = node;
		}
		
		return head;
	}

	//method to add two polynomial
	static Node sumOfPolynomial(Node head1, Node head2) {
		
		Node res = null;
		Node temp = null;
		while(head1 != null && head2 != null) {
			
			if(res == null) {
				
				if(head1.pow == head2.pow) {
					
					res = new Node(head1.data + head2.data, head1.pow);
				}
				
				else if(head1.pow > head2.pow) {
					
					res = new Node(head1.data, head1.pow);
					temp = res;
				}
				
				else {
					res  = new Node(head2.data, head2.pow);
					temp = res;
				}
			}
			
			else {
				
				if(head1.pow == head2.pow) {
					
					temp.next = new Node(head1.data + head2.data, head1.pow);
					temp = temp.next;
				}
				
				else if(head1.pow > head2.pow) {
					
					temp.next = new Node(head1.data, head1.pow);
					temp = temp.next;
				}
				
				else {
					temp.next = new Node(head2.data , head2.pow);
					temp = temp.next;
				}
				
			}
			
			if(head1.pow == head2.pow) {
				
				head1 = head1.next;
				head2 = head2.next;
			}
			
			else if(head1.pow > head2.pow) {head1 = head1.next;}
			else {head2 = head2.next;}	
		}
		
		return res;
	}
	//method to print the polynomial
	static void display(Node head) {
		
		if(head == null) return;
		while(head != null) {
			
			System.out.print(head.data+"x^"+head.pow+" + ");
			
			head = head.next;
			
			if(head.pow == 0) {
				System.out.print(head.data);
				return;
			}
		}
	}
	
	//main method
	public static void main(String[] args) {
		
		Node head1 = null;
		head1 = createPolynomialTerm(head1, 3, 2);
		createPolynomialTerm(head1, 2, 1);
		createPolynomialTerm(head1, 1, 0);
		
		System.out.print("Quadratic polynomial: ");
		display(head1);
		
		Node head2 = null;
		head2 = createPolynomialTerm(head2, 5, 3);
		createPolynomialTerm(head2, 10, 2);
		createPolynomialTerm(head2, -9, 1);
		createPolynomialTerm(head2, 20, 0);
		
		System.out.print("\nCubic Polynomial: ");
		display(head2);
		
		Node head3 = null;
		head3 = createPolynomialTerm(head3, 12, 5);
		createPolynomialTerm(head3, 11, 4);
		createPolynomialTerm(head3, 14, 3);
		createPolynomialTerm(head3, -16, 2);
		createPolynomialTerm(head3, 97, 1);
		createPolynomialTerm(head3, 16, 0);
		
		System.out.print("\nPolynomial of 5th power: ");
		display(head3);
		
		
		Node head4 = sumOfPolynomial(head1, head2);
		System.out.print("\nSum of Quadratic and Cubic polynomial: ");
		display(head4);
		
		
		Node head5 = sumOfPolynomial(head1, head3);
		System.out.print("\nSum of Quadratic and 5th power polynomial: ");
		display(head5);
		
		Node head6 = sumOfPolynomial(head2, head3);
		System.out.print("\nSum of Cubic and 5th power polynomial: ");
		display(head6);
		
		
	}

}
