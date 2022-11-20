package stacks;

import linkedlist.Node;

public class StackUsingLL<T> {
	private Node<T> head;
	private int size;
	
	public StackUsingLL() {
		head = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void push(T ele) {
		//insert at the beginning of LL
		Node<T> curr = new Node<>(ele);
		curr.setNext(head);
		head = curr;
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public T top() throws StackEmptyException {
		if(head==null)
			throw new StackEmptyException();
		
		return head.getData();
	}
	
	public T pop() throws StackEmptyException {
		if(head==null)
			throw new StackEmptyException();
		
		T temp = head.getData();
		head = head.getNext();
		size--;
		return temp;
	}

}
