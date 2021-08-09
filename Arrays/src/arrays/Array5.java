package arrays;

import java.util.List;
import java.util.Arrays;
import java.util.Spliterator;
import java.util.stream.Stream;

public class Array5 {

	public static void main(String[] args){
		
		Integer[] arr = {10, 20, 30, 40, 50};
		
		//Traversing array of Object using Arrays.spliterator(array) 
		
		System.out.println("Values in the arry");
		Spliterator<Integer> split = Arrays.spliterator(arr);
		split.forEachRemaining(n -> System.out.print(n+" "));
		
		List<Integer> list = Arrays.asList(arr);
		
		Spliterator<Integer> splitr = list.spliterator();
		
		System.out.println("\n\nValues in the list");
		
		splitr.forEachRemaining((n) -> System.out.print(n+" "));
		
		String[] name = {"Rupesh", "Ratan", "Riya", "Radhika", "Rohan", "Sachin"};
		List<String> list1 = Arrays.asList(name);
		
		System.out.println("\n\nName in the name list");
		Stream<String> stream = list1.stream();
		stream.forEach((str) -> System.out.print(str+" "));
		
		//Traversing array using Arrays.stream(array)
		System.out.println("\n\nTraversing ");
		Stream<String> stream2 = Arrays.stream(name);
		stream2.forEach(str -> System.out.print(str+" "));
	}

}
