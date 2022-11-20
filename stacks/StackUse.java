package stacks;

import java.util.Stack;

public class StackUse {

	public static void main(String[] args) throws StackFullException, StackEmptyException {
		//StackUsingArray s = new StackUsingArray();
		//StackUsingLL<Integer> s = new StackUsingLL<Integer>();
		//Stack<Integer> s = new Stack<>();
		StackUsingQueues<Integer> s = new StackUsingQueues<>();
		
		int[] arr = {5, 6, 7, 1, 9};
		
		for(int a: arr) {
			s.push(a);
		}
		
		System.out.println(s.isEmpty());
		System.out.println(s.size());
		System.out.println(s.top());
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
		
		System.out.println(s.isEmpty());

		
//		  System.out.println(s.size()); 
//		  s.push(10); 
//		  System.out.println(s.size());
//		  System.out.println(s.top()); 
//		  s.pop(); 
//		  System.out.println(s.size());
//		  System.out.println(s.isEmpty());
		 

	}

}
