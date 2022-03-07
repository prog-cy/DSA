package hashtableUsingOpenAddressing;

//HashTable implementation using Linear probing
// load factor in open addressing always lesser or equal to 1.
// load factor = size / capacity.

public class HashTable {
	
	//This is for storing key-value pair in hash table
	class Information{

		private Integer key;
		private String value;
		
		public Information(Integer key, String value){

			this.key = key;
			this.value =value;
		}
	}

	private Information[] hashtable;
	private int capacity;
	private int size;

	public HashTable(){

		this(10);
	}

	public HashTable(int capacity){

		this.capacity = capacity;
		this.size = 0;
		hashtable = new Information[capacity];
	}

	//This method will put key-value pair in the HashTable
	public void put(Integer key, String value){

		int index = hash(key);

		int verify_loop_once = index;

		while(hashtable[index] != null){

			if(hashtable[index].key.equals(key)){

				hashtable[index].value =value;
				return;
			}
			index = (index+1)%capacity;
			
			//This condition will check that index is repeating or not
			if(index == verify_loop_once){
				System.out.println("HashTable is overflow.");
				return;
			}
		}

		size++;

		Information info = new Information(key, value);

		hashtable[index] = info;
	}
	
	//Method to get the hash value of the corresponding key
	private int hash(Integer key){

		return key % capacity;
	}
	
	//Method to get the value corresponding to passed key
	public String get(Integer key){

		int index = hash(key);

		int verify_loop_once = index;

		while(true){
			
			//This loop will check the null value in HashTable
			while(hashtable[index] == null)
				index = (index+1)%capacity;

			if(hashtable[index].key.equals(key))
				return hashtable[index].value;
			
			index = (index+1)%capacity;

			if(verify_loop_once == index)
				break;
		}
		return null;
	}
	
	//Method to remove the value corresponding to passed key
	public String remove(Integer key){

		int index = hash(key);

		int verify_loop_once = index;

		String val = "";

		while(true){

			while(hashtable[index] == null)
				index = (index+1)%capacity;

			if(hashtable[index].key.equals(key)){

				size--;
				val = hashtable[index].value;
				hashtable[index] = null;
				break;
			}

			index = (index+1)%capacity;

			if(verify_loop_once == index)
				break;
		}

		return val;
	}

	public String toString(){

		StringBuffer result = new StringBuffer();

		result.append("{");

		for(int i = 0; ; i++){

			if(hashtable[i] != null){

				result.append(hashtable[i].key+"="+hashtable[i].value);
				result.append(", ");
			}

			if(i == capacity-1){
				if(result.length() == 1)
					return result.append("}").toString();
				result.delete(result.lastIndexOf(","), result.length());
				return result.append("}").toString();
			}
				
			
		}
	}
	
	public static void main(String[] args){

		HashTable table = new HashTable();

		table.put(101, "Rupesh");

		table.put(11, "Rohan");
		table.put(24, "Riya");
		table.put(78, "Rohan");

		System.out.println(table.size);

		table.put(25, "Saurabh");
		table.put(55, "Ashish");
		table.put(65, "Rajan");
		table.put(89, "Ritik");

		System.out.println(table.size);
		table.put(99, "Hemant");
		table.put(56, "Vanita");

		System.out.println(table);

		System.out.println(table.size);

		table.put(56, "Neo");

		System.out.println(table);

		table.put(90, "Vicky");

		System.out.println(table.size);

		System.out.println(table.get(56));

		System.out.println(table.get(99));

		table.remove(99);

		System.out.println(table.size);

		System.out.println(table);

		System.out.println(table.get(56));

		table.remove(56);

		System.out.println(table);

		System.out.println(table.get(24));

		System.out.println(table);

		table.remove(24);
		table.remove(25);
		table.remove(55);

		System.out.println(table);

		System.out.println(table.get(65));

		System.out.println(table.size);

		table.remove(65);
		table.remove(78);

		System.out.println(table);

		System.out.println(table.get(89));

		System.out.println(table.size);

		table.remove(101);
		table.remove(11);
		table.remove(89);

		System.out.println(table);

		System.out.println(table.size);

		table.put(34, "Aman");

		System.out.println(table);

		System.out.println(table.get(34));

		System.out.println(table.size);
		
	}

}
