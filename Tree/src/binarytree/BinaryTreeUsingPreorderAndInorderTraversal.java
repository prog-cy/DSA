package binarytree;

//Time complexity of this program is O(n^2) 
// In this program I have implemented how to consturct a tree when preorder and inorder of the tree is given

public class BinaryTreeUsingPreorderAndInorderTraversal {
	
	static class Node{
		
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	static int preIndex = 0;
	//This method builds tree for given preorder and inorder traversals
	static Node buildTree(int[] pre, int[] in, int inStart, int inEnd) {
		
		if(inStart > inEnd) //when inStart becomes greater than inEnd we will return null;
			return null;
		
		Node node = new Node(pre[preIndex++]);
		
		//This line checks that there is no left and right child 
		if(inStart == inEnd)
			return node;
		
		int index = search(in, inStart, inEnd, node.data); //this method searches for node.data element in inoder traversal array
		
		
		node.left = buildTree(pre, in, inStart, index-1);
		node.right = buildTree(pre, in, index+1, inEnd);
		
	
		return node;
	}
	
	//This method searches in inorder array for the element in preorder
	static int search(int[] arr, int start, int end, int value) {
		
		int i;
		
		for(i = start; i<=end; i++) {
			
			if(arr[i] == value)
				return i;
		}
		
		return i;
	}
	
	//Inorder traversal using stack.
	static void inorder(Node root) {
		
		if(root == null)return;
		
		java.util.Stack<Node> stack = new java.util.Stack<>();
		
		Node temp = root;
		
		while(stack.size() > 0 || temp != null) {
			
			if(temp != null) {
				
				stack.push(temp);
				temp = temp.left;
			}
			else {
				
				temp = stack.pop();
				
				System.out.print(temp.data+" ");
				
				temp = temp.right;
			}
		}
	}
	
	//main method
	public static void main(String[] args) {
		
		int[] preorder = {10, 20, 5, 6, 7, 9, 30, 53, 67}; //array of preorder
		int[] inorder = {6, 5, 7, 9, 20, 10, 53, 67, 30}; // array of inorder
		
		Node root = buildTree(preorder, inorder, 0, inorder.length-1);
		
		System.out.println("Inorder Traversal: ");
		inorder(root);
		
	}

}
