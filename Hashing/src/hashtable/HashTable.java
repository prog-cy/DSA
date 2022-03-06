package hashtable;

//Generic Implementation of HashTable using separate chaining collision resolution method
@SuppressWarnings("unchecked")
public class HashTable <K, V> {
	
	//HashNode class which is responsible for creating chain in HashTable
	@SuppressWarnings("hiding")
	private class HashNode<K, V>{
		
		private K key; //Generic key
		private V value; // Generic value;
		private HashNode<K, V> next; //reference to next node in the chain
		
		//Constructor to insert in the chain
		public HashNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	//Hash Function
	private int hash(K key) {
		
		Integer changedKey = (int)key;
		
		return changedKey % capacity;
	}
	
	private HashNode<K, V>[] buckets; //This the HashTable which stores address of head of every singly linked list in chain
	private Integer capacity; //This is the capacity of the buckets
	private Integer size; //This is the number of HashNode in the buckets
	
	//Default constructor to initialize buckets of capacity 10
	public HashTable() {
		this(10);
	}
	
	//Parameterized constructor to initialize buckets of any capacity
	
	public HashTable(int capacity) {
		this.capacity = capacity;
		buckets = new HashNode[capacity];
		size = 0;
	}
	
	//Method to add put element in the HashTable
	@SuppressWarnings("rawtypes")
	public void put(K key, V value) {
		
		int index = hash(key);
		
		HashNode head = buckets[index];
		
		while(head != null) {
			
			if(head.key == key)
				head.value = value;
			head = head.next;
		}
		
		size++;
		
		head = buckets[index];
		
		
		HashNode node = new HashNode(key, value);
		
		node.next = head;
		
		buckets[index]  = node;
	}
	
	//Method to print the HashTable {} in this bracket separated by comma
	public String toString() {
		
		StringBuilder result = new StringBuilder();
		
		result.append("{");
		
		for(int i = 0; ; i++) {
			
			HashNode<K, V> head = buckets[i];
			
			while(head != null) {
				
				result.append(head.key+"="+head.value);
				result.append(", ");
				head = head.next;
			}
			
			if(i == capacity-1) {
				
				if(result.length() == 1)
					return result.append("}").toString();
				result.delete(result.lastIndexOf(","), result.length());
				result.append("}");
				return result.toString();
			}
		}
	}
	
	//Method to get the value from the HashTable by passing the key
	public V get(K key) {
		
		int index = hash(key);
		
		HashNode<K, V> head = buckets[index];
		
		while(head != null) {
			
			if(head.key == key)
				return head.value;
			head = head.next;
		}
		
		return null;
	}
	
	//Method to remove the value from the HashTable by passing key to the remove method
	public V remove(K key) {
		
		int index = hash(key);
		
		HashNode<K, V> head = buckets[index];
		
		HashNode<K, V> temp = null;
		
		V val = null;
		
		if(head.key == key) {
			
			val = head.value;
			size--;
			buckets[index] = head.next;
		}
		
		else {
			
			while(head != null) {
				
				temp = head;
				
				if(head.next.key == key) {
					
					size--;
					val = head.next.value;
				}
				
				head = head.next;
			}
			
			temp.next = temp.next.next;
		}
		
		return val;
	}
	
	//Method to check that given key is present or not
	public boolean containsKey(K key) {
		
		int index = hash(key);
		
		HashNode<K, V> head = buckets[index];
		
		while(head != null) {
			
			if(head.key == key)
				return true;
			head = head.next;
		}
		
		return false;
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
}
