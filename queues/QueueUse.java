package queues;

public class QueueUse {

	public static void main(String[] args) {
		//QueueUsingArray q = new QueueUsingArray(3);
		//QueueUsingLL<Integer> q = new QueueUsingLL<>();
		QueueUsingStacks<Integer> q = new QueueUsingStacks<>();
		
		int[] arr = {10, 20, 30, 40, 50}; 
		
		for(int ele: arr) {
				q.enqueue(ele);
		}
		
		try {
			System.out.println(q.front());
		} catch (QueueEmptyException e) {
			e.printStackTrace();
		}
		
		System.out.println(q.size());
		System.out.println(q.isEmpty());
		
		while(!q.isEmpty()) {
			try {
				System.out.println(q.dequeue());
			} catch (QueueEmptyException e) {
				//Will never reach there
			}
		}
		
		System.out.println(q.isEmpty());
	}

}
