package polynomial;


//In this program I am going to calculate the subtraction of two polynomial

public class SubtractionOfPolynomial {
	
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
	
	//method to create a term of polynomial
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
	
	static Node subtractionOfPolynomial(Node head1, Node head2) {
		
		Node res = null;
		Node temp = null;
		
		while(head1 != null && head2 != null) {
			
			if(res == null) {
				
				if(head1.pow == head2.pow) {
					res = new Node(head1.data - head2.data, head1.pow);
					temp = res;
				}
				else if(head1.pow > head2.pow) {
					
					res = new Node(head1.data, head1.pow);
					temp = res;
				}
				
				else {
					
					res = new Node(head2.data, head2.pow);
					temp = res;
				}
			}
				
				else {
					
					if(head1.pow == head2.pow) {
						
						temp.next = new Node(head1.data - head2.data, head1.pow);
						temp = temp.next;
					}
					
					else if(head1.pow > head2.pow) {
						temp.next = new Node(head1.data, head1.pow);
						temp = temp.next;
					}
					else {
						temp.next = new Node(head2.data, head2.pow);
						temp = temp.next;
					}
					
					
				}
				
				if(head1.pow == head2.pow) {
					
					head1 = head1.next;
					head2 = head2.next;
				}
				else if(head1.pow > head2.pow) {
					head1 = head1.next;
				}
				else {
					head2 = head2.next;
				}
			
		}
		return res;
	}
	//method to display the polynomial
	static void display(Node head) {
		
		if(head == null) return;
		System.out.print(head.data+"x^"+head.pow+" + ");
		if(head.pow == 1) {
			System.out.print(head.next.data);
			return;
		}
		display(head.next);
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
		
		Node head3 = subtractionOfPolynomial(head1, head2);
		System.out.print("\nSubtraction of Quadratic and Cubic Polynomial: ");
		display(head3);
	}
}
