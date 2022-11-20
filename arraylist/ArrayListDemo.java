package arraylist;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		ArrayList<Integer> arr1 = new ArrayList<>(); //default capacity = 10
		arr1.add(10);
		arr1.add(20);
		arr1.add(30);
		arr1.add(1, 80); //shifts elements from index 1 towards right
		
		for(int i=0; i<arr1.size(); i++) {
			System.out.println(arr1.get(i));
		}
		
		//Enhanced for loop(foreach loop)
		for(int i: arr1) {
			System.out.println(i);
		}
		
//		System.out.println(arr1.size());
//		System.out.println(arr1.get(2));
//		
//		arr1.remove(2); //shifts elements from index 2 towards left
//		System.out.println(arr1.get(2));
//		
//		Integer i = 10;
//		arr1.remove(i);
//		System.out.println(arr1.get(0));
//		System.out.println(arr1);
//		
//		arr1.set(0, 70);
//		System.out.println(arr1);
		
//		ArrayList<Integer> arr2 = new ArrayList<>(20); //default capacity = 20
//		arr2.add(null);
//		System.out.println(arr2.size());
//		System.out.println(arr2.get(0));
	}

}
