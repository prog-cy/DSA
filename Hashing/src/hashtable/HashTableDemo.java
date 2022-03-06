package hashtable;

public class HashTableDemo {
	
	public static void main(String[] args) {
		
		//HashTable having (Integer, String) key-value pair
		HashTable<Integer, String> table1 = new HashTable<>(); //HashTable-1
		
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
		
		//HashTable having (Double, String) key-value pair
		HashTable<Double, String> table2 = new HashTable<>(); //HashTable-2
		
		table2.put(89.90, "Radha");
		table2.put(45.67, "Rahul");
		table2.put(90.45436, "Vanita");
		
		System.out.println(table2);
		
		System.out.println(table2.get(45.67));
		
		table2.remove(45.67);
		
		System.out.println(table2);
		
		table2.put(84.67, "Vaibhav");
		
		System.out.println(table2);
		
		System.out.println(table2.size());

		System.out.println(table2.containsKey(84.67));
		
		//HashTable having (Character, String) key-value pair
		HashTable<Character, String> table3 = new HashTable<>();
		
		table3.put('A', "Apple");
		table3.put('B', "Boat");
		table3.put('C', "Caot");
		table3.put('D', "Dolphin");
		table3.put('E', "Eye");
		
		System.out.println(table3);
		
		System.out.println(table3.get('A'));
		
		table3.remove('A');
		
		table3.put('E', "Elephant");
		
		System.out.println(table3);
		
		System.out.println("There are "+table3.size()+" entries in HashTable");
		
		//HashTable having (String, String) key-value pair
		HashTable<String, String> table4 = new HashTable<>();
		
		table4.put("45", "Rupesh");
		table4.put("Rohan", "Rohan is very Integelligent Boy.");
		table4.put("Rohan", "Rohan does not respect elders.");
		
		System.out.println(table4);
		
		System.out.println(table4.size());
		
	}

}
