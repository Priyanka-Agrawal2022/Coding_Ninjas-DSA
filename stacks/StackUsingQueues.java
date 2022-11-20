package stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues<T> {
	private Queue<T> q1;
	private Queue<T> q2;
	
	public StackUsingQueues() {
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}
	
	public int size() {
		return q1.size();
	}
	
	public boolean isEmpty() {
		return q1.size() == 0;
	}
	
	public void push(T ele) {
		q1.add(ele);
	}
	
	public T top() throws StackEmptyException {
		if(q1.size() == 0)
				throw new StackEmptyException();
		
		while(q1.size() > 1) {
			q2.add(q1.poll());
		}
		
		T temp = q1.poll();
		
		while(!q2.isEmpty()) {
			q1.add(q2.poll());
		}
		
		q1.add(temp);
		
		return temp;
	}
	
	public T pop() throws StackEmptyException {
		if(q1.size() == 0)
			throw new StackEmptyException();
	
		while(q1.size() > 1) {
			q2.add(q1.poll());
		}
		
		T temp = q1.poll();
		
		while(!q2.isEmpty()) {
			q1.add(q2.poll());
		}
		
		return temp;
	}
}
