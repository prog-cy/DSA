package arrays;
import java.util.*;

class Point{
	
	int x, y;
	
	Point(int x, int y){
		
		this.x = x;
		this.y = y;
	}
}
class SortAccordingToX implements Comparator<Point>{
	
	//Sorts array of points in ascending order
	public int compare(Point p1, Point p2) {
		
		return p1.x - p2.x;
	}
}

//main class
public class SortingArrayUsingComparator {
	
	public static String toString(Point p) {
		
		return "("+p.x+", "+p.y+")";
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Point[] points = new Point[5];
		
		for(int i = 0; i<5; i++) {
			
			System.out.println("Enter the number: ");
			int num = scan.nextInt();
			
			points[i] = new Point(num, i);
		}
		
		System.out.println("Array Before sorting: ");
		for(Point point : points) {
			
			System.out.println(toString(point));
		}
		
		//Sorting array
		Arrays.sort(points, new SortAccordingToX());
		
		System.out.println("Array After sorting: ");
		
		for(Point point : points) {
			
			System.out.println(toString(point));
		}
		
		scan.close();
	}
}
