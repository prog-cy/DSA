package arrays;
import java.io.*;

//Creating a static array and inserting data at any position
public class Array2 {
	
	static int size = 0;
	
	//method to display the array elements
	void display(int[] arr, int size) {
		
		for(int i = 0; i<size; i++)
			System.out.print(arr[i]+" ");
	}
	
	//method to insert at beginning
	void insertAtBegin(int[] arr, int n) {
		
		try {
			
			for(int i = size; i>=0; i--)
				arr[i+1] = arr[i];
			arr[0] = n;
			size++;
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("\nOverflow");
		}
	}
	
	//method to insert at end
	void insertAtend(int[] arr, int n) {
		
		try {
			arr[size++] = n;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("\nOverflow");
		}
	}
	
	//method to insert data at any position in the array
	void insertAtPos(int[] arr, int n, int pos) {
		
		try {
			if(pos == 1)
				new Array2().insertAtBegin(arr, n);
			else if(pos == size+1)
				new Array2().insertAtend(arr, n);
			else {
				
				for(int i = size; i>=pos-1; i--)
					arr[i+1] = arr[i];
				arr[pos-1] = n;
				size++;
			}
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("\nOverflow");
		}
	}
	
	//method to reverse an array
	void reverser(int[] arr) {
		
		int l = 0;
		int r = size-1;
		
		while(l<r) {
			int t = arr[l];
			arr[l] = arr[r];
			arr[r] = t;
			l++;
			r--;
		}
	}
	
	//method to search an element in the array
	//we will search element in the array using linear search algorithm
	boolean find(int[] arr, int data) {
		
		boolean found = false;
		
		for(int i = 0; i<size; i++) {
			
			if(arr[i] == data) {
				found = true;
				break;
			}
		}
		
		return found;
	}

	public static void main(String[] args) throws IOException {
		
		//these two lines used for taking input
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(input);
		
		//creating object of Array2 class
		Array2 ob = new Array2();
		
		//creating an 1-D array
		int arr[] = new int[50];
		
		System.out.println("Enter number");
		String str = br.readLine();
		
		String[] s = str.split("\\s");
		
		size = s.length;
		
		for(int i = 0; i<size; i++)
			arr[i] = Integer.parseInt(s[i]);
		
		
		System.out.println("\nElements in array");
		ob.display(arr, size);
		
		System.out.println("\nEnter element which you want to insert at beginning");
		int data = Integer.parseInt(br.readLine());
		
		System.out.println("\nAfter inserting "+data+" at beginning");
		ob.insertAtBegin(arr, data);
		ob.display(arr, size);
		
		System.out.println("\nEnter element which you want to insert at end");
		int data1 = Integer.parseInt(br.readLine());
		ob.insertAtend(arr, data1);
		System.out.println("\nAfter inserting "+data1+" at end");
		ob.display(arr, size);
		
		System.out.print("\nEnter position: ");
		int pos = Integer.parseInt(br.readLine());
		System.out.println("Enter element which you want to insert at "+pos+"th position: ");
		int data3 = Integer.parseInt(br.readLine());
		ob.insertAtPos(arr, data3, pos);
		System.out.println("\nInserting "+data3+" at position "+pos);
		ob.display(arr, size);
		
		System.out.println("\nAfter reversing the array");
		ob.reverser(arr);
		ob.display(arr, size);
		
		System.out.println("\nEnter element which you want to search in the array");
		int search = Integer.parseInt(br.readLine());
		if(ob.find(arr, search))
			System.out.println("present");
		else
			System.out.println("Not present");
	}

}
