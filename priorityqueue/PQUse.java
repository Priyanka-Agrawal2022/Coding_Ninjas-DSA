package priorityqueue;

public class PQUse {

	public static void main(String[] args) throws PriorityQueueException {
		PQ_MinHeap<String> pq = new PQ_MinHeap<>();
		pq.inser("abc", 15);
		pq.inser("def", 13);
		pq.inser("fsas", 90);
		pq.inser("fshagha", 150);
		pq.inser("xvzjdshfj", 120);
		
		while(!pq.isEmpty()) {
			System.out.println(pq.getMin());
			pq.removeMin();
		}
	}
}
