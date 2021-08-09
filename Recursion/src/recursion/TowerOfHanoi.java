package recursion;

//Tower of hanoi solving using recursion

public class TowerOfHanoi { 
	
	//this is recursive method to solve this problem
	static void TOH(int n, char src, char aux, char dest) {
		
		if(n == 1) {
			System.out.println("Move " +n+ " disk from "+src+ " --> " +dest);
			return;
		}
		TOH(n-1, src, dest, aux);
		System.out.println("Move " +n+ " disk from "+src+ " --> " +dest);
		TOH(n-1, aux, src, dest);
		
	}
	
	//main method
	public static void main(String[] args) {

		TOH(5, 'A', 'B', 'C');
	}

}
