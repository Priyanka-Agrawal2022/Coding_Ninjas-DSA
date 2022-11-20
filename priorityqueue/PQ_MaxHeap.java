package priorityqueue;

import java.util.ArrayList;

public class PQ_MaxHeap<T> {
	ArrayList<Element<T>> heap;
	
	public PQ_MaxHeap() {
		heap = new ArrayList<>();
	}
	
	public void inser(T value, int priority) {
		Element<T> ele = new Element<>(value, priority);
		heap.add(ele);
		int childIndex = heap.size()-1; //last index
		int parentIndex = (childIndex-1)/2;
		
		while(childIndex > 0) {
			if(heap.get(childIndex).priority > heap.get(parentIndex).priority) {
				Element<T> temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				
				childIndex = parentIndex;
				parentIndex = (childIndex-1)/2;
			}
			else
				return;
		}
	}
	
	public T getMax() throws PriorityQueueException {
		if(isEmpty())
			throw new PriorityQueueException();
		
		return heap.get(0).value;
	}
	
	public T removeMax() throws PriorityQueueException {
		if(isEmpty())
			throw new PriorityQueueException();
		
		Element<T> removedEle = heap.get(0);
		T ans = removedEle.value;
		
		int lastIndex = heap.size()-1;
		heap.set(0, heap.get(lastIndex));
		heap.remove(lastIndex);
		
		int parentIndex = 0;
		int leftChildIndex = 2*parentIndex + 1;
		int rightChildIndex = 2*parentIndex + 2;
		
		while(leftChildIndex < heap.size()) {
			int maxIndex = parentIndex;
			
			if(heap.get(leftChildIndex).priority > heap.get(maxIndex).priority)
				maxIndex = leftChildIndex;

			if((rightChildIndex < heap.size()) && (heap.get(rightChildIndex).priority > heap.get(maxIndex).priority))
				maxIndex = rightChildIndex;
			
			if(maxIndex == parentIndex)
				return ans;
			
			Element<T> temp = heap.get(parentIndex);
			heap.set(parentIndex, heap.get(maxIndex));
			heap.set(maxIndex, temp);
			
			parentIndex = maxIndex;
			leftChildIndex = 2*parentIndex + 1;
			rightChildIndex = 2*parentIndex + 2;
		}
		
		return ans;
	}
	
	public int size() {
		return heap.size();
	}
	
	public boolean isEmpty() {
		if(heap.size() == 0)
			return true;
		else
			return false;
	}
}
