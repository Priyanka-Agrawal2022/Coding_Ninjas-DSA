package binaryTree;

public class BST {
	private BinaryTreeNode<Integer> root;
	private int size;
	
	public int size() {
		return this.size;
	}
	
	public boolean isPresent(int x) {
		return isPresentHelper(root, x);
	}
	
	private static boolean isPresentHelper(BinaryTreeNode<Integer> node, int x) {
		//base case
		if(node == null)
			return false;
		
		//small step
		if(node.data == x)
			return true;
		
		//recursive calls
		if(x < node.data)
			return isPresentHelper(node.left, x);
		else
			return isPresentHelper(node.right, x);
	}
	
	public void insert(int x) {
		root = insertHelper(root, x);
		size++;
	}
	
	private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> node, int x) {
        //base case
		if(node == null) {
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(x);
            return newNode;
        }
		
		//recursive calls
        if(x < node.data) {
            node.left = insertHelper(node.left, x);
        }
        else if(x >= node.data) {
            node.right = insertHelper(node.right, x);
        }
        
        //small step
        return node;
    }
	
	public boolean delete(int x) {
		BSTDeleteReturn ans = deleteHelper(root, x);
		root = ans.node;
		
		if(ans.isDeleted)
			size--;
		
		return ans.isDeleted;
	}
	
	private static BSTDeleteReturn deleteHelper(BinaryTreeNode<Integer> node, int x) {
        //base case
		if(node == null)
			return new BSTDeleteReturn(null, false);
		
		//recursive calls
		if(x < node.data) {
			BSTDeleteReturn leftOutput = deleteHelper(node.left, x);
			//small step
			node.left = leftOutput.node;
			leftOutput.node = node;
			return leftOutput;
		}
		else if(x > node.data) {
			BSTDeleteReturn rightOutput = deleteHelper(node.right, x);
			//small step
			node.right = rightOutput.node;
			rightOutput.node = node;
			return rightOutput;
		}
		else {
			//no child
			if(node.left == null && node.right == null)
				return new BSTDeleteReturn(null, true);
			//only left child
			else if(node.left != null && node.right == null)
				return new BSTDeleteReturn(node.left, true);
			//only right child
			else if(node.right != null && node.left == null)
				return new BSTDeleteReturn(node.right, true);
			//both children
			else {
				//small step
				int rightMin = minimum(node.right);
				node.data = rightMin;
				//recursive call
				BSTDeleteReturn rightOutput = deleteHelper(node.right, rightMin);
				//small step
				node.right = rightOutput.node;
				return new BSTDeleteReturn(node, true);
			}
		}
    }
	
	private static int minimum(BinaryTreeNode<Integer> node) {
		//base case
		if(node == null)
			return Integer.MAX_VALUE;
		
		//recursive calls
		int leftMin = minimum(node.left);
		int rightMin = minimum(node.right);
		
		//small step
		return Math.min(node.data, Math.min(leftMin, rightMin));
	}
	
	public void printTree() {
		printTreeHelper(root);
	}
	
	private static void printTreeHelper(BinaryTreeNode<Integer> node) {
		//base case
		if(node == null)
			return;
		
		//small step
		System.out.print(node.data + ": ");
		if(node.left != null)
			System.out.print("L" + node.left.data + ", ");
		if(node.right != null)
			System.out.print("R" + node.right.data);
		System.out.println();
		
		//recursive calls
		printTreeHelper(node.left);
		printTreeHelper(node.right);
	}
}
