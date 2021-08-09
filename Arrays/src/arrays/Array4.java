package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Spliterator;

//sorting array of objects using method
//1. sort(T[] a, int fromIndex, int toIndex, Comparator<super T> c)
//2. sort(T[] a, Comparator<super T>c)

class Student{
	
	String name, address;
	int rollnumber;
	
	Student(int rollnumber, String name, String address){
		
		this.rollnumber = rollnumber;
		this.name = name;
		this.address = address;
	}
	
	public String toString() {
		
		return rollnumber+" "+name+" "+address;
	}
	
	
}

class SortByroll implements Comparator<Student>{
	
	public int compare(Student s1, Student s2) {
		
		return s1.rollnumber - s2.rollnumber;
	}
}


public class Array4 {

	public static void main(String[] args) {
		
		Student[] s = new Student[3];
		
		s[0] = new Student(111, "Rupesh", "aaaa");
		s[1] = new Student(332, "Ram" , "bbbcdds");
		s[2] = new Student(222, "Radhika", "cccfsg");
		
		System.out.println("Students in the class");
		for(Student a : s)
			System.out.println(a);
		
		Arrays.sort(s, 1, 2, new SortByroll());
		
		System.out.println("\nStudents After sorting in the class");
		for(Student a : s)
			System.out.println(a);
		
		SortByroll sortbyroll = new SortByroll();
		
		Arrays.sort(s, 0, 3, sortbyroll);
		
		System.out.println("\nStudents After sorting in the class");
		for(Student a : s)
			System.out.println(a);
		
		Arrays.sort(s, sortbyroll);
		System.out.println("\nSorted");
		for(int i = 0; i<s.length; i++)
			System.out.println(s[i]);
		
		System.out.println("\nTraversing array of objects using spliterator");
		Spliterator<Student> split = Arrays.spliterator(s);
		split.forEachRemaining(student -> System.out.println(student));

	}

}
