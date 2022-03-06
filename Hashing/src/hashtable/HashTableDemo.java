package hashtable;

public class HashTableDemo {
	
	public static void main(String[] args) {
		
		HashTable<Integer, String> table1 = new HashTable<>();
		
		table1.put(12, "Rupesh");
		table1.put(99, "Sachin");
		table1.put(123, "Saurabh");
		table1.put(78, "Ritik");
		table1.put(89, "Ankit");
		
		System.out.println(table1);
		
		System.out.println("There are "+table1.size()+" entries in the HashTable.");
		System.out.println(table1.get(12));
		
		System.out.println(table1.containsKey(78));
		
		table1.remove(123);
		
		System.out.println(table1);
		
		System.out.println("There are "+table1.size()+" entries in the HashTable.");
	}

}
