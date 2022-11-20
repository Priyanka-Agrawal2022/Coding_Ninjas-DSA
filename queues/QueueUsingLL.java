package queues;

import linkedlist.Node;

public class QueueUsingLL<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void enqueue(T ele) {
		Node<T> curr = new Node<>(ele);
		
		if(head == null) { //size == 0
			head = curr;
			tail = curr;
		}
		else {
			tail.setNext(curr);
			tail = curr;
		}
		
		size++;
	}
	
	public T front() throws QueueEmptyException {
		if(size == 0)
			throw new QueueEmptyException();
		
		return head.getData();
	}
	
	public T dequeue() throws QueueEmptyException {
		if(head == null)
			throw new QueueEmptyException();
		
		T temp = head.getData();
		head = head.getNext();
		
		if(head == null) {
			tail = null;	//no element is left in LL after deletion
		}
		
		size--;
		return temp;
	}
}