package arrays;

//Dynamic array in java
@SuppressWarnings("unchecked")
class Array<T>{
	
	T[] arr; // array of type T
	private int len = 0; //this is temporary size of the array
	private int size = 0; //this is original size of the array
	
	//default constructor it is important to initialize the size of array at the beginning 
	//when we create object of Array<T> class this constructor works first
	Array() {this(5);}
	
	//parameterized constructor
	Array(int size) {
		this.size = size;
//		arr = new T[size]; //can't create an array of generic type due to ambiguity
		arr = (T[]) new Object[size]; //In this line we have allocated space for type T array object
	}
	
	//method to display data in the array
	void display() {
		
		for(int i = 0; i<len; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	//adding data to Array 
	void add(T elem) {
		if(len >= size) {
			size *= 2;
			T[] new_arr = (T[]) new Object[size];
			for(int i = 0; i<len; i++)
				new_arr[i] = arr[i];
			arr = new_arr;
		}
		arr[len] = elem;
		len++;
	}
	
	//adding data at any position
	void addAt(T elem, int index) {
		
		try {
			if(index <= -1 || index >= len+1) throw new ArrayIndexOutOfBoundsException();
			
			else if(index >= size) {
				size *= 2;
				T[] new_arr = (T[]) new Object[size];
				for(int i = 0; i<len; i++)
					new_arr[i] = arr[i];
				arr = new_arr;
				arr[index] = elem;
				len++;
			}
			
			else {
				
				for(int i = len-1; i>=index; i--) {
					arr[i+1] = arr[i];
				}
				arr[index] = elem;
				len++;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException e) {System.out.println("Invalid index");}
				
	}
	
	//this method merge two array into one
	void addAll(Array<T> ob2) {
			
		int total_length = size() + ob2.size();
		
		if(total_length <= capacity()) {
			for(int i = size(); i<total_length; i++)
				arr[i] = ob2.arr[i-size()];
			len += ob2.size();
		}
		else if(total_length > capacity()) {
			size *= 3;
			T[] new_arr = (T[])new Object[size];
			for(int i = 0; i<len; i++)
				new_arr[i] = arr[i];
			arr = new_arr;
			for(int i = size(); i<total_length; i++)
				arr[i] = ob2.arr[i-size()];
			len += ob2.size();
		} 
	}
	//this method returns present size of the array
	public int size() {return len;}
	
	//this method return real size of the array
	public int capacity() {return size;}
	
	//this method returns an element on the given index
	public T get(int index) {return arr[index];}
	
	//this method clears all element from the array list
	void clear() {
		
		for(int i = 0; i<len; i++)
			arr[i] = null;
		len = 0;
	}
	
	//this method will remove element at given index
	void removeAt(int index) {
		
		try {
			if(index <= -1 || index >= len) throw new IllegalArgumentException();
			else if(index == len-1) len--;
			else {
				for(int i = index; i<len; i++)
					arr[i] = arr[i+1];
				len--;
			}
			
		}catch(IllegalArgumentException e) {System.out.println("Invalid index");}
	}
	
	//this method will remove a specific element from the list
	//If duplicate elements are present this method will remove first occurrence of element
	void remove(T elem) {
		int index = 0;
		for(int i = 0; i<len; i++) {	
			if(arr[i] == elem) {
				index = i;
				break;
			}
		}
		removeAt(index);
	}
	
	//this method will reverse the array
	void reverse() {
		int start = 0;
		int end = len-1;
		
		while(start < end) {
			T temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
		
}

public class ArrayList1 {

	public static void main(String[] args) {
		
		Array<Integer> ls1 = new Array<Integer>();
		System.out.println("Capacity of list1: "+ls1.capacity());
		ls1.add(12);
		ls1.add(23);
		ls1.add(34);
		ls1.add(45);
		ls1.add(30);
		ls1.add(35);
		ls1.add(45);
		ls1.add(45);
		System.out.println("Capacity of list1: "+ls1.capacity());
		
		ls1.display();
		System.out.println("After reversing the list ");
		ls1.reverse();
		ls1.display();
		ls1.reverse();
		System.out.println("Element at index 4: "+ls1.get(4));
		System.out.println("Size of the array is: "+ls1.size());
		ls1.addAt(56, 1);
		ls1.display();
		
		System.out.println("Size of the array is: "+ls1.size());
		ls1.addAt(45, -2);
		ls1.add(88);
		ls1.add(34);
		ls1.display();
		ls1.addAt(56, -1);
		ls1.addAt(90, 11);
		ls1.addAt(90, 13);
		ls1.display();
		System.out.println("Size of the array is: "+ls1.size());
		ls1.removeAt(3);
		ls1.display();
		System.out.println("Size of the array is: "+ls1.size());
		ls1.removeAt(2);
		ls1.display();
		System.out.println("Size of the array is: "+ls1.size());
		ls1.remove(34);
		ls1.display();
		System.out.println("Size of the array is: "+ls1.size());
		
		//Creating an array of String
		Array<String> ls2 = new Array<>();
		ls2.add("Ram");
		ls2.add("Riya");
		ls2.add("Rinki");
		ls2.addAt("Rupesh", 0);
		
		ls2.display();
		System.out.println("List size is: "+ls2.size());
		System.out.println("Element at 2: "+ls2.get(2));
		ls2.remove("Rinki");
		ls2.display();
		System.out.println("List size is: "+ls2.size());
		
		Array<Integer> ls3 = new Array<>();
		ls3.add(10);
		ls3.add(20);
		ls3.add(30);
		
		ls3.display();
		System.out.println("List 2 size: "+ls3.size());
		System.out.println("List 1 size: "+ls1.size());
		System.out.println("Capacity of list1: "+ls1.capacity());
		
		ls1.addAll(ls3);
		ls1.display();
		System.out.println("List 1 size: "+ls1.size());
		
		Array<Integer> ls4 = new Array<>();
		for(int i = 5; i<34; i++)
			ls4.add(i);
		ls4.display();
		System.out.println("List 3 size: "+ls4.size());
		System.out.println("Capacity of list1: "+ls1.capacity());
		
		ls1.addAll(ls4);
		ls1.display();
		System.out.println("List 1 size: "+ls1.size());
		System.out.println("Capacity of list1: "+ls1.capacity());
	}

}
