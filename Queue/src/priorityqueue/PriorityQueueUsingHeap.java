package priorityqueue;
import java.util.ArrayList;

class PriorityQueue2{
	
	ArrayList<Integer> heap;
	
	PriorityQueue2(){
		
		heap = new ArrayList<>();
	}
	
	//method to insert in priority queue
	void add(int data) {
		
		heap.add(data);
		
		int i = heap.size()-1;
		
		//this is logic for upheapify
		while(i>0) {
			
			int parent = (i-1)/2;
			
			if(heap.get(parent) > heap.get(i)) {
				
				int temp = heap.get(parent);
				heap.set(parent, heap.get(i));
				heap.set(i, temp);
			}
			
			i = parent;
		}
	}
	
	//method to delete element from priority queue
	void delete() {
		
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		int i = 0;
		
		//this is logic for down heapify
		while(i<(heap.size()-1)/2) {
			
			int min = heap.get(2*i+1) < heap.get(2*i+2) ? 2*i + 1 : 2*i+2;
			
			if(heap.get(i) > heap.get(min)) {
				
				int temp = heap.get(min);
				heap.set(min, heap.get(i));
				heap.set(i, temp);
				i = min;
			}
			else
				break;
			
		}
	}
	
	//this method will return highest priority value from the priority queue
	int highestPriorityValue() {
		
		if(heap.size()-1 == 0)return -1;
		else
			return heap.get(0);
	}
	
	void display() {
		
		for(int i = 0; i<heap.size(); i++)
			System.out.print(heap.get(i)+" ");
		System.out.println();
	}
}

public class PriorityQueueUsingHeap {
	
	public static void main(String[] args) {
		
		PriorityQueue2 pq = new PriorityQueue2();
		
		pq.add(100);
		pq.add(20);
		pq.add(5);
		pq.add(50);
		pq.add(10);
		pq.add(21);
		pq.add(34);
		pq.add(1);
		pq.add(3);
		
		System.out.println("Highest Priority value: "+ pq.highestPriorityValue());
		
		pq.display();
		
		pq.delete();
		
		pq.display();
		
		pq.delete();
		
		pq.display();
		
		pq.delete();
		
		pq.display();
	}
}
