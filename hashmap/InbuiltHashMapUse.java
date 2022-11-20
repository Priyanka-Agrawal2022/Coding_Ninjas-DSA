package hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class InbuiltHashMapUse {

	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 2, 3, 1, 6, 2, 5};
		ArrayList<Integer> ans = removeDuplicates(arr);
		System.out.println(ans);
	}
	
	public static ArrayList<Integer> removeDuplicates(int[] arr) {
		if(arr.length == 0)
			return null;
		
		HashMap<Integer, Boolean> m = new HashMap<>();
		ArrayList<Integer> ans = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			if(!m.containsKey(arr[i])) {
				m.put(arr[i], true);
				ans.add(arr[i]);
			}
		}
		
		return ans;
	}
}
