package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {

	public static void main(String[] args) {
//		TreeNode<Integer> root = new TreeNode<>(4);
//		TreeNode<Integer> node1 = new TreeNode<>(2);
//		TreeNode<Integer> node2 = new TreeNode<>(3);
//		TreeNode<Integer> node3 = new TreeNode<>(1);
//		TreeNode<Integer> node4 = new TreeNode<>(5);
//		TreeNode<Integer> node5 = new TreeNode<>(6);
//		
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
//		
//		node2.children.add(node4);
//		node2.children.add(node5);
		
		TreeNode<Integer> root = takeInputLevelWise();
		
//		printTree(root);
		printTreeBetter(root);
		System.out.println(numberOfNodes(root));
	}
	
	public static void printTree(TreeNode<Integer> root) {
		//special case not base case
		if(root == null)
			return;
		
		//small step
		System.out.print(root.data + " ");
		
		//recursive calls
		for(int i=0; i<root.children.size(); i++) {
			printTree(root.children.get(i));
		}
	}
	
	public static void printTreeBetter(TreeNode<Integer> root) {
		//special case not base case
		if(root == null)
			return;
		
		//small step
		System.out.print(root.data + ": ");
		
		for(int i=0; i<root.children.size(); i++) {
			TreeNode<Integer> child = root.children.get(i);
			System.out.print(child.data + " ");
		}
		
		System.out.println();
		
		//recursive calls
		for(int i=0; i<root.children.size(); i++) {
			TreeNode<Integer> child = root.children.get(i);
			printTreeBetter(child);
		}
	}
	
	public static int numberOfNodes(TreeNode<Integer> root) {
		//special case not base case
		if(root == null)
			return 0;
		
		int count = 1;
		
		//recursive calls
		for(int i=0; i<root.children.size(); i++) {
			TreeNode<Integer> child = root.children.get(i);
			int childCount = numberOfNodes(child);
			count += childCount;
		}
		
		return count;
	}
	
	public static TreeNode<Integer> takeInputLevelWise() {
		Scanner sc = new Scanner(System.in);
		Queue<TreeNode<Integer>> pendingChildren = new LinkedList<TreeNode<Integer>>();
		
		System.out.println("Enter root data: ");
		int rootData = sc.nextInt();
		
		if(rootData == -1)
			return null;
		
		TreeNode<Integer> root = new TreeNode<>(rootData);
		pendingChildren.add(root);
		
		while(!pendingChildren.isEmpty()) {
			TreeNode<Integer> front = pendingChildren.poll();
			System.out.println("Enter no. of children for " + front.data + ": ");
			int n = sc.nextInt();
			
			for(int i=0; i<n; i++) {
				System.out.println("Enter data for " + i + "th children of " + front.data + ": ");
				int childData = sc.nextInt();
				TreeNode<Integer> child = new TreeNode<>(childData);
				front.children.add(child);
				
				pendingChildren.add(child);
			}
		}
		
		return root;
	}
}
