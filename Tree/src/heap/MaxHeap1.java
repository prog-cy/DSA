package heap;

//Implementin Heap using static array 

public class MaxHeap1 {
	
	static int[] arr = new int[8]; //arr used to create heap
	static int size = 1; //size variable used to keep track of the how many elements present in the array
	
	//method to insert data in the heap
	static void insert(int key) {
		
		arr[size++] = key;
		
		int i = size-1;
		
		while(i > 1) {
			
			int parent = i/2;
			
			if(arr[parent] < arr[i]) {
				
				int temp = arr[parent];
				arr[parent] = arr[i];
				arr[i] = temp;
			}
			
			i = parent;
		}
		
	}
	
	static void display() {
		
		for(int i = 1; i<size; i++) {
			
			System.out.print(arr[i]+" ");
		}
	}
	
	static void preorder(int index) {
		
		if(index >= size)return;
		
		System.out.print(arr[index] +" ");
		preorder(2*index);
		preorder((2*index) + 1);
	}
	
	//main method
	public static void main(String[] args) {
		
		insert(5);
		insert(9);
		insert(8);  
		insert(7);
		insert(6);
		insert(10);
		insert(40); 
		
		System.out.print("Max Heap: ");
		display();
		
		System.out.print("\nPreorder: ");
		preorder(1);
	}

}
