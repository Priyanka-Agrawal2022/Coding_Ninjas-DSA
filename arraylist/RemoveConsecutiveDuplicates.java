package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveConsecutiveDuplicates {

	public static ArrayList<Integer> rsd(int[] a) {
		int n = a.length;
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(a[0]);
		
		for(int i=1; i<n; i++) {
			if(a[i] != a[i-1])
				arr.add(a[i]);
		}
		
		return arr;
	}
	
	public static ArrayList<Integer> recursiveFun(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(a[0]);
		
		int n = a.length;
		
		if(n==1)
			return arr;
		
		arr = helper(arr, a, 1);
		return arr;
	}
	
	public static ArrayList<Integer> helper(ArrayList<Integer> arr, int[] a, int s) {
		int n = a.length;
		
		//base case
		if(s == n-1) {
			if(a[s] != a[s-1])
				arr.add(a[s]);
			return arr;
		}
		
		//small step(induction step)
		if(a[s] != a[s-1])
			arr.add(a[s]);
		
		//recursive call(induction hypothesis)
		arr = helper(arr, a, s+1);
		return arr;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] a = new int[8];
		
		for(int i=0; i<8; i++) {
			a[i] = sc.nextInt();
		}
		
//		ArrayList<Integer> arr = rsd(a);
		ArrayList<Integer> arr = recursiveFun(a);
		
		System.out.println(arr);
	}

}
