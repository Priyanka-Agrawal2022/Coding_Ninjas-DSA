package stacks;

public class StackUsingArray {
	private int[] data;
	private int topIndex;
	
	public StackUsingArray() {
		data = new int[10];
		topIndex = -1;
	}
	
	public StackUsingArray(int size) {
		data = new int[size];
		topIndex = -1;
	}
	
	public void push(int ele) throws StackFullException {
		//if stack is full
		if(topIndex == data.length-1)
			//throw new StackFullException();
			doubleCapacity();
		
		data[++topIndex] = ele;
	}
	
	private void doubleCapacity() {
		int[] temp = data;
		data = new int[2*temp.length];
		
		for(int i=0; i<temp.length; i++) {
			data[i] = temp[i];
		}
		
	}

	public int top() throws StackEmptyException {
		if(topIndex == -1)
			throw new StackEmptyException();
		
		return data[topIndex];
	}
	
	public int pop() throws StackEmptyException {
		if(topIndex == -1)
			throw new StackEmptyException();
		
		int temp = data[topIndex--];
		return temp;
	}
	
	public boolean isEmpty() {
		if(topIndex == -1)
			return true;
		else
			return false;
	}
	
	public int size() {
		return topIndex+1;
	}
}
