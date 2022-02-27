package queueProblems;
import java.util.*;
//Generating binary number from 1 to n using queue
// Only number will be given
// for example 
// 5
// "1", "10", "11", "100", "101"
// Loop runs only n/2 times;

public class BinaryNumberFrom1toN {
	
	static void generateBinary1toN(int n) {
		
		Queue<String> queue = new LinkedList<>();
		
		queue.add("1");
		
		for(int i = 1; i<=n/2; i++) {
			
			String s = queue.poll(); //this line removes peek element from the queue
			
			System.out.print(s+" ");
			queue.add(s+"0");
			queue.add(s+"1");
		}
		
		//this loop prints remaining numbers present in queue
		while(!queue.isEmpty()) {
			
			if((n&1) == 0 && queue.size() == 1) //this line checks that n is even or not
				return;
			System.out.print(queue.remove()+" ");
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number : ");
		
		int n = scan.nextInt();
		
		System.out.println("Binary number from 1 to "+n);
		
		generateBinary1toN(n);
		
		scan.close();
	}

}
