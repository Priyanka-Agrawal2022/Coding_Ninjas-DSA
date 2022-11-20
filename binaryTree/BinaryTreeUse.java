package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {

	public static void main(String[] args) {
//		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//		
//		BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<>(2);
//		BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<>(3);
//		
//		root.left = rootLeft;
//		root.right = rootRight;
//		
//		BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<>(4);
//		rootLeft.right = twoRight;
//		
//		BinaryTreeNode<Integer> threetLeft = new BinaryTreeNode<>(5);
//		rootRight.left = threetLeft;	

		// BinaryTreeNode<Integer> root = takeInput();
		// printTree(root);

//		BinaryTreeNode<Integer> root = takeInputBetter(true, 0, false);
//		BinaryTreeNode<Integer> root = takeInputLevelWise();
//		printTreeLevelWise(root);
//		printTreeDetailed(root);
//		System.out.println("Number of nodes: " + numOfNodes(root));
//		System.out.println("Largest: " + largest(root));
//		System.out.println("Height: " + height(root));
//		System.out.println("Number of leaf nodes: " + numOfLeafNodes(root));
//		System.out.println("Printing nodes at depth k:");
//		printAtDepthK(root, 2); 
//		root = removeLeaf(root);
//		System.out.println("****************");
//		printTreeDetailed(root);
//		System.out.println("Is balanced? " + isBalanaced(root));
//		System.out.println("Is balanced? " + isBalanacedBetter(root).isBalanced);
//		System.out.println("Diameter of tree: " + diameterOfBinaryTree(root));
		
//		int[] pre = {1, 2, 4, 5, 3};
		int[] in = {4, 2, 5, 1, 3}; 
		BinaryTreeNode<Integer> root = SortedArrayToBST(in, 5);
		System.out.println("Is BST? " + isBSTOther(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
//		IsBSTReturn ans = isBSTBetter(root);
//		System.out.println("Is BST? " + ans.isBST + " " + ans.min + " " + ans.max);
//		BinaryTreeNode<Integer> root = buildTreeFromPreIn(pre, in);
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		BinaryTreeNode<Integer> root1 = SortedArrayToBST(arr, 7);
		System.out.println("Is BST? " + isBSTOther(root1, Integer.MIN_VALUE, Integer.MAX_VALUE));
//		IsBSTReturn ans1 = isBSTBetter(root1);
//		printTreeDetailed(root);
//		System.out.println("Is BST? " + ans1.isBST + " " + ans1.min + " " + ans1.max);
	}

	public static BinaryTreeNode<Integer> takeInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter root data: ");
		int data = sc.nextInt();

		if (data == -1)
			return null;
		else {
			BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);

			BinaryTreeNode<Integer> leftChild = takeInput();
			BinaryTreeNode<Integer> rightChild = takeInput();

			root.left = leftChild;
			root.right = rightChild;

			return root;
		}
	}

	public static BinaryTreeNode<Integer> takeInputBetter(boolean isRoot, int parentData, boolean isLeft) {
		if (isRoot)
			System.out.println("Enter root data: ");
		else if (isLeft)
			System.out.println("Enter left child of " + parentData + ": ");
		else
			System.out.println("Enter right child of " + parentData + ": ");

		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();

		if (data == -1)
			return null;
		else {
			BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);

			BinaryTreeNode<Integer> leftChild = takeInputBetter(false, data, true);
			BinaryTreeNode<Integer> rightChild = takeInputBetter(false, data, false);

			root.left = leftChild;
			root.right = rightChild;

			return root;
		}
	}

	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter root data: ");
		int rootData = sc.nextInt();

		if (rootData == -1)
			return null;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();
		pendingChildren.add(root);

		while (!pendingChildren.isEmpty()) {
			BinaryTreeNode<Integer> front = pendingChildren.poll();

			System.out.println("Enter left child of " + front.data + ": ");
			int leftData = sc.nextInt();
			if (leftData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftData);
				front.left = leftChild;
				pendingChildren.add(leftChild);
			}

			System.out.println("Enter right child of " + front.data + ": ");
			int rightData = sc.nextInt();
			if (rightData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightData);
				front.right = rightChild;
				pendingChildren.add(rightChild);
			}
		}

		return root;
	}

	public static int numOfNodes(BinaryTreeNode<Integer> root) {
		// base case
		if (root == null)
			return 0;

		// recursive calls
		int leftNodeCount = numOfNodes(root.left);
		int rightNodeCount = numOfNodes(root.right);

		// small step
		return 1 + leftNodeCount + rightNodeCount;
	}

	public static int numOfLeafNodes(BinaryTreeNode<Integer> root) {
		// base case
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return 1;

		// recursive calls
		int leftLeafCount = numOfLeafNodes(root.left);
		int rightLeafCount = numOfLeafNodes(root.right);

		// small step
		return leftLeafCount + rightLeafCount;
	}

	public static void printAtDepthK(BinaryTreeNode<Integer> root, int k) {
		// base case
		if (root == null)
			return;

		// small step
		if (k == 0) {
			System.out.print(root.data + " ");
			return;
		}

		// recursive calls
		printAtDepthK(root.left, k - 1);
		printAtDepthK(root.right, k - 1);
	}

	public static int height(BinaryTreeNode<Integer> root) {
		// base case
		if (root == null)
			return 0;

		// recursive calls
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		// small step
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public static void printTree(BinaryTreeNode<Integer> root) {
		// base case
		if (root == null)
			return;

		// small step
		System.out.println(root.data);

		// recursive calls
		printTree(root.left);
		printTree(root.right);
	}

	public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
		// base case
		if (root == null)
			return;

		// small step
		System.out.print(root.data + ": ");

		if (root.left != null)
			System.out.print("L" + root.left.data + ", ");

		if (root.right != null)
			System.out.print("R" + root.right.data);

		System.out.println();

		// recursive calls
		printTreeDetailed(root.left);
		printTreeDetailed(root.right);
	}
	
	public static void printTreeLevelWise(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		
		Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();
		pendingChildren.add(root);
		
		while(!pendingChildren.isEmpty()) {
			BinaryTreeNode<Integer> front = pendingChildren.poll();
			System.out.print(front.data + ": ");
			
			if(front.left != null) {
				pendingChildren.add(front.left);
				System.out.print("L" + front.left.data + ", ");
			}
			
			if(front.right != null) {
				pendingChildren.add(front.right);
				System.out.print("R" + front.right.data);
			}
			
			System.out.println();
		}
	}

	public static BinaryTreeNode<Integer> removeLeaf(BinaryTreeNode<Integer> root) {
		// base case
		if (root == null)
			return null;

		if (root.left == null && root.right == null)
			return null;

		root.left = removeLeaf(root.left);
		root.right = removeLeaf(root.right);
		return root;
	}

	public static boolean isBalanaced(BinaryTreeNode<Integer> root) {
		// base case
		if (root == null)
			return true;

		// small step
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		System.out.println(leftHeight - rightHeight);
		if (Math.abs(leftHeight - rightHeight) > 1)
			return false;

		// recursive calls
		boolean isLeftBalanced = isBalanaced(root.left);
		boolean isRightBalanced = isBalanaced(root.right);

		return isLeftBalanced && isRightBalanced;
	}

	public static BalancedTreeReturn isBalanacedBetter(BinaryTreeNode<Integer> root) {
		// base case
		if (root == null) {
			BalancedTreeReturn ans = new BalancedTreeReturn(0, true);
			return ans;
		}

		// recursive calls
		BalancedTreeReturn leftOutput = isBalanacedBetter(root.left);
		BalancedTreeReturn rightOutput = isBalanacedBetter(root.right);

		// small step
		int height = 1 + Math.max(leftOutput.height, rightOutput.height);
		boolean isBalanced = true;

		if (Math.abs(leftOutput.height - rightOutput.height) > 1)
			isBalanced = false;
		if (!leftOutput.isBalanced || !rightOutput.isBalanced)
			isBalanced = false;

		BalancedTreeReturn ans = new BalancedTreeReturn(height, isBalanced);
		return ans;
	}

	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;

		TreeDiameterReturn ans = helper(root);
		return ans.diameter;
	}

	public static TreeDiameterReturn helper(BinaryTreeNode<Integer> root) {
		if (root == null)
			return new TreeDiameterReturn(0, 0);

		TreeDiameterReturn leftOutput = helper(root.left);
		TreeDiameterReturn rightOutput = helper(root.right);

		int height = 1 + Math.max(leftOutput.height, rightOutput.height);
		int diameter = Math.max((1 + leftOutput.height + rightOutput.height),
				Math.max(leftOutput.diameter, rightOutput.diameter));

		TreeDiameterReturn ans = new TreeDiameterReturn(height, diameter);
		return ans;
	}
	
	public static BinaryTreeNode<Integer> buildTreeFromPreIn(int[] pre, int[] in) {
		BinaryTreeNode<Integer> root = buildTreeFromPreInHelper(pre, in, 0, pre.length-1, 0, in.length-1);
		return root;
	}
	
	public static BinaryTreeNode<Integer> buildTreeFromPreInHelper(int[] pre, int[] in, int sp, int ep, int si, int ei) {
		//base case
		if(sp > ep)
			return null;
		
		int rootData = pre[sp];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		
		int rootIndex;
		for(rootIndex = si; rootIndex <= ei; rootIndex++) {
			if(in[rootIndex] == rootData)
				break;
		}
		
		//Assuming root actually exists in inorder
		int siLeft = si;
		int eiLeft = rootIndex - 1;
		int spLeft = sp + 1;
		int epLeft = spLeft + (eiLeft - siLeft + 1) - 1;
		int spRight = epLeft + 1;
		int siRight = rootIndex + 1;
		int epRight = ep;
		int eiRight = ei;
		
		
		BinaryTreeNode<Integer> leftSubtree = buildTreeFromPreInHelper(pre, in, spLeft, epLeft, siLeft, eiLeft);
		BinaryTreeNode<Integer> rightSubtree = buildTreeFromPreInHelper(pre, in, spRight, epRight, siRight, eiRight);
		
		root.left = leftSubtree;
		root.right = rightSubtree;
		
		return root;
	}
	
	public static int largest(BinaryTreeNode<Integer> root) {
		// base case
		if (root == null)
			return Integer.MIN_VALUE;

		// recursive calls
		int largestLeft = largest(root.left);
		int largestRight = largest(root.right);

		// small step
		return Math.max(root.data, Math.max(largestLeft, largestRight));
	}
	
	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n) {
		if(n == 0)
            return null;
        
        BinaryTreeNode<Integer> root = SortedArrayToBSThelper(arr, 0, n-1);
		return root;
	}
	
	public static BinaryTreeNode<Integer> SortedArrayToBSThelper(int[] arr, int s, int e) {
        //base case
        if(s > e)
        	return null;
      
        if(s == e)
            return new BinaryTreeNode<>(arr[s]);
        
        //small step
        int midIndex = (s+e)/2;
        int rootData = arr[midIndex];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        
        //recursive calls
        BinaryTreeNode<Integer> leftSubtree = SortedArrayToBSThelper(arr, s, midIndex-1);
        BinaryTreeNode<Integer> rightSubtree = SortedArrayToBSThelper(arr, midIndex+1, e);
        
        //small step
        root.left = leftSubtree;
        root.right = rightSubtree;
        
        return root;
    }
	
	public static int minimum(BinaryTreeNode<Integer> root) {
		//base case
		if (root == null)
			return Integer.MAX_VALUE;

		//recursive calls
		int minimumLeft = minimum(root.left);
		int minimumRight = minimum(root.right);

		//small step
		return Math.min(root.data, Math.min(minimumLeft, minimumRight));
	}
	
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		//base case
		if(root == null)
			return true;
		
		//small step
		if(root.data <= largest(root.left))
			return false;
		if(root.data > minimum(root.right))
			return false;
		
		//recursive calls
		return isBST(root.left) && isBST(root.right);
	}
	
	public static IsBSTReturn isBSTBetter(BinaryTreeNode<Integer> root) {
		//base case
		if(root == null)
			return new IsBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
		
		//recursive calls
		IsBSTReturn leftAns = isBSTBetter(root.left);
		IsBSTReturn rightAns = isBSTBetter(root.right);
		
		//small step
		int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
		int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
		boolean isBST = true;
		
		if(!leftAns.isBST || !rightAns.isBST)
			isBST = false;
		else if(root.data <= leftAns.max)
			isBST = false;
		else if(root.data > rightAns.min)
			isBST = false;
		
		IsBSTReturn ans = new IsBSTReturn(min, max, isBST);
		return ans;
	}
	
	public static boolean isBSTOther(BinaryTreeNode<Integer> root, int min, int max) {
		//base case
		if(root == null)
			return true;
		
		//small step
		if(root.data < min || root.data > max)
			return false;
		
		//recursive calls
		return isBSTOther(root.left, min, root.data - 1) && isBSTOther(root.right, root.data, max);
	}
}
