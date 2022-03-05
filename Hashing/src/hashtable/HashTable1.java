package hashtable;

//HashTable implementation using separate chaining collision method

public class HashTable1 {
	
	//This is singly linked list node for storing (key, value) in hashtable
	private class HashNode{
		
		private Integer key;
		private String value;
		private HashNode next;
		
		public HashNode(Integer key, String value) {
			
			this.key = key;
			this.value = value;
		}
	}
	
	//Modular Hash function implementation is below
	private int hash(Integer key) {
		
		return key%capacity;
	}
	
	private HashNode[] buckets; //This is HashTable which stores address of singly linked list
	private int capacity; //This is the capacity of HashTable
	private int size; //This is the total number of HashNodes in HashTable
	
	//Default constructor used to initialize the capacity equal to 10 of hashtable
	public HashTable1() {
		this(10);
	}
	
	//Parameterized constructor
	public HashTable1(int capacity) {
		this.capacity = capacity;
		buckets  = new HashNode[capacity];
		this.size = 0;
	}
	
	//Method to get size of the HashTable
	public int size() {
		
		return size;
	}
	
	//Method to check that HashTable is empty or not
	public boolean isEmpty() {
		
		return size == 0;
	}
	
	//Method to get capacity of the HashTable
	public int capacity() {
		
		return capacity;
	}
	
	//method to put (key, value) pair in the HashTable
	public void put(Integer key, String value) {
		
		int index = hash(key); //This calculate index corresponding to key
		
		HashNode head = buckets[index]; //This assigns starting address of buckets[index] 
		
		//The while(){} code checks that the given key is already present if it is there
		// it only changes the value of that HashNode
		while(head != null) {
			
			if(head.key == key) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		
		size++; //Increasing size if new node is added
		
		head = buckets[index]; //We have to again assign head the starting address because 
		//head goes inside the while loop 
		
		HashNode node = new HashNode(key, value);
		
		node.next = head;
		
		buckets[index] = node;
		
	}
	
	//Method to display the HashTable
	public String toString() {
		
		StringBuilder result = new StringBuilder();
		
		result.append("{");
		
		for(int i = 0; ;i++) {
			
			HashNode head = buckets[i];
			
			while(head != null) {
				
				result.append(head.key+"="+head.value+", ");
				head = head.next;
			}
			
			if(i == capacity-1) {
				result.delete(result.lastIndexOf(","), result.length());
				result.append("}");
				return result.toString();
			}
		}
	}
	
	//main method
	public static void main(String[] args) {
		
		HashTable1 table = new HashTable1();
		
		table.put(11, "Rupesh");
		table.put(34, "Radha");
		table.put(89, "Rajan");
		table.put(90, "Saurabh");
		table.put(78, "Rahul");
		table.put(31, "Ashish");
		table.put(99, "Sachin");
		
		System.out.println(table);
	}
}
