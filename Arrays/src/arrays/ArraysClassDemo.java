package arrays;

import java.util.Arrays;
import java.util.List;

//I will discuss some important method of Arrays class 
public class ArraysClassDemo {

	public static void main(String[] args) {
		
		//1. static List asList(T... a) method to convert an array into List
		//for primitive type array it does not return same array
		int[] a = {10, 20, 30, 40};
		System.out.println("Array List: "+Arrays.asList(a));
		
		//for wrapper classes it returns list of array
		Integer[] a1 = {10, 20, 30, 40};
		List<Integer> list = Arrays.asList(a1);
		System.out.println("Array List: "+list);
		
		String[] s = {};
		List<String> list1 = Arrays.asList(s);
		System.out.println("Array List: "+list1);
		
		//2. static int binarySearch(array, key)
		int[] arr = {4, 7, 2, 8, 90, 34, 98};
		Arrays.sort(arr);
		int key = 3;
		int index = Arrays.binarySearch(arr, key);
		System.out.println(key+" is present at "+index+" position.");
		
		//3. static<T> int binarySearch(T[] a, int fromIndex, int toIndex, T key)
		int key1 = 7;
		int index1 = Arrays.binarySearch(arr, 0, 4, key1);
		System.out.println(key1+" is present at "+index1+".");
		
		//4. compare(array1, array2)
		int[] arr1 = {10, 20, 15, 22, 35};
		int[] arr2 = {10, 22, 15, 45, 67};
		
		System.out.println("Integer array on comparison: "+Arrays.compare(arr1, arr2));
		
		//5. copyOf(array, newLength)
		int[] arr3 = Arrays.copyOf(arr2, 5);
		System.out.println("arr2: "+Arrays.toString(arr2));
		System.out.println("arr3: "+Arrays.toString(arr3));
		
		//6. copyOfRange(array, fromIndex, endIndex)
		int[] arr4 = Arrays.copyOfRange(arr1, 0, 3);
		System.out.println("arr4: "+Arrays.toString(arr4));
		
		//copy one array into another using copyOfRange()
		int[] copyArray = Arrays.copyOfRange(a, 0, a.length);
		System.out.println("copyArray: "+Arrays.toString(copyArray));
		
		//7. deepEquals(int[] array1, int[] array2)
		int[][] twoD = {{10, 20, 30, 40}};
		int[][] twoD1 = {{10, 20, 30}};
		System.out.println("Integes Arrays on comparison: "+Arrays.deepEquals(twoD, twoD1));
		
		//8. deepHashCode(Object[] array)
		System.out.println("HashCode of array: "+Arrays.deepHashCode(twoD));
		
		//9. deepToString(Object[] array)
		System.out.println("Integer Array: "+Arrays.deepToString(twoD1));
		
		//10. equals(array1, array2)
		System.out.println("Integer array on comparison: " +Arrays.equals(arr, arr1));
		
		//11. fill(originalArray, fillValue)
		int[] fillArray = {10, 20, 30, 40, 56, 78, 98, 45};
		System.out.println("fillArray: "+Arrays.toString(fillArray));
		Arrays.fill(fillArray, 50);
		System.out.println("fillArray: "+Arrays.toString(fillArray));
		
		//12. hashCode(array) 
		System.out.println("HashCode: "+Arrays.hashCode(fillArray));
		
		//13. mismatch(array1, array2)
		System.out.println("The elements mismatched at index: "+Arrays.mismatch(arr2, arr1));
		
		//14. parallelSort(array)
		int[] array = {4, 3, 67, 12, 45};
		System.out.println("Unsorted Array: "+Arrays.toString(array));
		Arrays.parallelSort(array);
		System.out.println("Sorted Array: "+Arrays.toString(array));
		
		//15. sort(array)
		System.out.println("Unsorted Array: "+Arrays.toString(arr1));
		Arrays.sort(arr1);
		System.out.println("Sorted Array: "+Arrays.toString(arr1));
		
		//16. sort(array, fromIndex, endIndex)
		System.out.println("Unsorted Array: "+Arrays.toString(arr2));
		Arrays.sort(arr2, 1, 3);
		System.out.println("Sorted Array fromIndex to endIndex: "+Arrays.toString(arr2));
		
		//17. toString(array)
		System.out.println("Array in the form of list: "+Arrays.toString(arr));
	}

}
