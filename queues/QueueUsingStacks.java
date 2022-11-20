package queues;

import java.util.Stack;

public class QueueUsingStacks<T> {
	private Stack<T> s1;
	private Stack<T> s2;
	
	public QueueUsingStacks() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}
	
	public int size() {
		return s1.size();
	}
	
	public boolean isEmpty() {
		return s1.size() == 0;
	}
	
	public void enqueue(T ele) {
		s1.push(ele);
	}
	
	public T front() throws QueueEmptyException {
		if(s1.size() == 0)
			throw new QueueEmptyException();
		
		while(s1.size() > 1) {
			s2.push(s1.pop());
		}
		
		T temp = s1.peek();
		
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
		
		return temp;
	}
	
	public T dequeue() throws QueueEmptyException {
		if(s1.size() == 0)
			throw new QueueEmptyException();
		
		while(s1.size() > 1) {
			s2.push(s1.pop());
		}
		
		T temp = s1.pop();
		
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
		
		return temp;
	}

}
