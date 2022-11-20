package priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class InbuiltPQ {

	public static void main(String[] args) {
		int[] arr = { 4, 7, 3, 2, 8, 9, 6, 1 };
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//
//		for (int i = 0; i < arr.length; i++) {
//			pq.add(arr[i]);
//		}
//
//		System.out.println(pq.peek());
//
//		while (!pq.isEmpty()) {
//			System.out.println(pq.peek());
//			pq.poll();
//		}
//		
//		System.out.println(kLargestElements(arr, 4));
		System.out.println(kSmallestElements(8, arr, 4));

	}

	public static ArrayList<Integer> kLargestElements(int[] arr, int k) {
		int n = arr.length;

		if (n < k)
			return null;

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}

		for (int i = k; i < n; i++) {
			int ele = arr[i];
			int min = pq.peek();

			if (min < ele) {
				pq.poll();
				pq.add(ele);
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();

		while (!pq.isEmpty()) {
			ans.add(pq.poll());
		}

		return ans;
	}
	
	public static ArrayList<Integer> kSmallestElements(int n, int[] arr, int k) {
        if(n<k)
            return null;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<k; i++) {
            pq.add(arr[i]);
        }
        
        for(int i=k; i<n; i++) {
            int ele = arr[i];
            int max = pq.peek();
            
            if(max > ele) {
                pq.poll();
                pq.add(ele);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        
        return ans;
	}
}