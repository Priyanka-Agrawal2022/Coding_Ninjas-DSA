package queues;

public class QueueUsingArray {
	private int[] data;
	private int front;
	private int rear;
	private int size;
	
	public QueueUsingArray() {
		data = new int[5];
		front = -1;
		rear = -1;
	}
	
	public QueueUsingArray(int capacity) {
		data = new int[capacity];
		front = -1;
		rear = -1;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void enqueue(int ele) {
		if(size == data.length)
			doubleCapacity();
		
		if(size == 0) {
			front = 0;
		}
		
		rear++;							//rear = (rear + 1)%data.length
									   //rear ranges from 0 to data.length-1
		if(rear == data.length) {
			rear = 0; //circular queue
		}
		
		data[rear] = ele;
		size++;
	}
	
	private void doubleCapacity() {
		int[] temp = data;
		data = new int[2*temp.length];
		
		int index = 0;
		for(int i=front; i<temp.length; i++) {
			data[index] = temp[i];
			index++;
		}
		
		for(int i=0; i<front-1; i++) {
			data[index] = temp[i];
			index++;
		}
		
		front = 0;
		rear = temp.length - 1;
	}

	public int front() throws QueueEmptyException {
		if(size == 0) {
			throw new QueueEmptyException();
		}
		
		return data[front];
	}
	
	public int dequeue() throws QueueEmptyException {
		if(size == 0) {
			throw new QueueEmptyException();
		}
		
		int temp = data[front];			//front = (front + 1)%data.length				   				
		front++;				   //front ranges from 0 to data.length-1
		
		if(front == data.length) {
			front = 0; //circular queue
		}
		
		size--;
		
		if(size == 0) {
			front = -1;
			rear = -1;
		}
		
		return temp;
	}
	
}
