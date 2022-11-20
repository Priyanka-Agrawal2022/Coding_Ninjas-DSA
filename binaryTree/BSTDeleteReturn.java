package binaryTree;

public class BSTDeleteReturn {
	public BinaryTreeNode<Integer> node;
	public boolean isDeleted;
	
	public BSTDeleteReturn(BinaryTreeNode<Integer> node, boolean isDeleted) {
		this.node = node;
		this.isDeleted = isDeleted;
	}
}
