package treetraversal;

//Recursive implementation of level order traversal

public class RecLevelOrderTraversal {
	
	//method to print all the nodes at given level
	static void printAtLevel(Node<Integer> root, int level) {
		
		if(root == null) return;
		
		if(level == 0) {
			System.out.print(root.data+" ");
			return;
		}
		
		printAtLevel(root.left, level-1);
		printAtLevel(root.right, level - 1);
	}
	
	//method to get the height of the tree
	static int getHeight(Node<Integer> root) {
		
		if(root == null)  return 0;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	//method to print the tree in level order
	static void levelOrder(Node<Integer> root) {
		
		int h = getHeight(root);
		
		for(int i = 0; i<h; i++)
			printAtLevel(root, i);
	}
	
	public static void main(String[] args) {
		Node<Integer> root = new Node<>(1);
		root.left = new Node<>(2);
		root.left.left = new Node<>(4);
		root.left.right = new Node<>(5);
		root.right = new Node<>(3);
		root.right.left = new Node<>(6);
		root.right.right = new Node<>(7);
		root.right.right.left = new Node<>(8);
		
		System.out.print("Level order: ");
		levelOrder(root);
	}

}
