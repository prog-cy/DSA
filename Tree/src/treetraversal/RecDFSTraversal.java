package treetraversal;


//Recursive implementaion of DFS traversal
/* There are three ways of DFS 
 * 
 *	1. Preorder
 *	2. Postorder
 *	3. Inorder
 */

public class RecDFSTraversal {
	
	//method for preorder traversal
	static void preorder(Node<Character> root) {
		
		if(root == null) return;
		
		System.out.print(root.data+" ");
		
		preorder(root.left);
		preorder(root.right);
	}
	
	//method for postorder traversal
	static void postorder(Node<Character> root) {
		
		if(root == null)return;
		
		postorder(root.left);
		postorder(root.right);
		
		System.out.print(root.data+" ");
	}
	
	//method for inorder traversal
	static void inorder(Node<Character> root) {
		if(root == null) return;
		
		inorder(root.left);
		
		System.out.print(root.data+" ");
		
		inorder(root.right);
	}
	
	//main method
	public static void main(String[] args) {
		Node<Character> root = new Node<>('A');
		root.left = new Node<>('B');
		root.left.left = new Node<>('D');
		root.left.right = new Node<>('E');
		root.right = new Node<>('C');
		root.right.right = new Node<>('F');
		root.right.right.left = new Node<>('G');
		root.right.right.right = new Node<>('H');
		
		System.out.print("Preorder: ");
		preorder(root);
		
		System.out.print("\nPostorder: ");
		postorder(root);
		
		System.out.print("\nInorder: ");
		inorder(root);
	}
}

