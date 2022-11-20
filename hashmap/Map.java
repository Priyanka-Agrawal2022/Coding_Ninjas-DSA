package hashmap;

import java.util.ArrayList;

public class Map<K, V> {
	public ArrayList<MapNode<K, V>> buckets;
	public int count;
	public int noOfBuckets;
	
	public Map() {
		buckets = new ArrayList<>();
		noOfBuckets = 5;
		
		for(int i=0; i<noOfBuckets; i++) {
			buckets.add(null);
		}
	}
	
	private int getBucketIndex(K key) {
		int hc = key.hashCode();
		int index = hc%noOfBuckets;
		return index;
	}
	
	public double loadFactor() {          //n/b
		return (1.0*count)/noOfBuckets;
	}
	
	public void insert(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		
		MapNode<K, V> temp = head;
		//if key is already present, update its value
		while(temp != null) {
			if(temp.key.equals(key)) {
				temp.value = value;
				return;
			}
			temp = temp.next;
		}
		
		//if key is not present, create a new node & insert at 0th position of LL
		MapNode<K, V> newNode = new MapNode<>(key, value);
		newNode.next = head;
		buckets.set(bucketIndex, newNode);
		count++;
		
		double loadFactor = (1.0*count)/noOfBuckets;
		if(loadFactor > 0.7)
			reHash();
	}
	
	private void reHash() {
		ArrayList<MapNode<K, V>> oldBucket = buckets;
		buckets = new ArrayList<>();
		
		count = 0;
		noOfBuckets = 2*noOfBuckets;
		
		for(int i=0; i<noOfBuckets; i++) {
			buckets.add(null);
		}
		
		for(int i=0; i<oldBucket.size(); i++) {
			MapNode<K, V> head = oldBucket.get(i);
			
			while(head != null) {
				insert(head.key, head.value);
				head = head.next;
			}
		}
	}

	public int size() {
		return count;
	}
	
	public V getValue(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		
		MapNode<K, V> temp = head;
		while(temp != null) {
			if(temp.key.equals(key))
				return temp.value;
			
			temp = temp.next;
		}
		
		return null;
	}
	
	public V removeKey(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		
		MapNode<K, V> temp = head;
		MapNode<K, V> prev = null;
		while(temp != null) {
			if(temp.key.equals(key)) {
				if(prev != null)
					prev.next = temp.next;
				else
					buckets.set(bucketIndex, temp.next);
				
				count--;
				return temp.value;
			}
			
			prev = temp;
			temp = temp.next;
		}
		
		return null;
	}
}
