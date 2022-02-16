package heap;
import java.util.PriorityQueue;

//Min heap using priority queue

public class HeapUsingPriorityQueue {

	static PriorityQueue<Integer> minheap = new PriorityQueue<>();
	
	public static void main(String[] args) {
		
		minheap.add(20);
		minheap.add(50);
		minheap.add(5);
		minheap.add(50);
		minheap.add(56);
		minheap.add(1);
		minheap.add(2);
		minheap.add(30);
		minheap.add(4);
		
		display();
		
		minheap.remove();
		
		display();
	}
	
	static void display() {
		
		for(int val : minheap)
			System.out.print(val+" ");
		System.out.println();
	}
}
