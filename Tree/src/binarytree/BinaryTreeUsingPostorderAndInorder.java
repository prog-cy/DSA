package binarytree;

//In this program I have implemented how to build a tree when postorder and inorder traversal of the tree is given
// Time complexity of this program is O(n^2)

public class BinaryTreeUsingPostorderAndInorder {
	
	static class Node{
		
		int data;
		Node left, right;
		
		Node(int data){
			
			this.data = data;
			left = right = null;
		}
	}
	
	
	static int postIndex;
	
	static Node buildTree(int[] post, int[] in, int inStart, int inEnd) {
		
		if(inStart > inEnd)
			return null;
		
		Node node = new Node(post[postIndex--]);
		
		if(inStart == inEnd)
			return node;
		
		int index = search(in, inStart, inEnd, node.data);
		
		node.right = buildTree(post, in, index+1, inEnd);
		node.left = buildTree(post, in, inStart, index-1);
		
		
		return node;
	}
	
	//method to search the element in given inorder array
	static int search(int[] arr, int start, int end, int value) {
		
		int i;
		
		for(i = start; i<=end; i++) {
			
			if(arr[i] == value)
				return i;
		
		}
		
		return i;
	}
	
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
		
		int[] postorder = {6, 9, 7, 5, 20, 67, 53, 30, 10};
		int[] inorder = {6, 5, 7, 9, 20, 10, 53, 67, 30};
		
		postIndex = postorder.length - 1; //we assign this index because we traverse the postorder from last index to first index
		
	
		Node root = buildTree(postorder, inorder, 0, inorder.length-1);
		
		System.out.println("Inorder: ");
		
		inorder(root);
		
	}

}
