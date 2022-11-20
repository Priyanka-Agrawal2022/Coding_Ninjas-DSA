package stacks;

import java.util.Scanner;
import java.util.Stack;

public class CheckRedundantBrackets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an expression: ");
		String str = sc.next();

		System.out.println(isRedundant(str));

	}

	private static boolean isRedundant(String str) {
		int n = str.length();
        int i=0, count=0;
        Stack<Character> s = new Stack<>();
        
        while(i<n) {
            char ch = str.charAt(i);
            
            if(ch != ')') 
                s.push(ch);
            else {
                count=0;
                
                while(!s.isEmpty() && s.pop() != '(') {
                    count++;
                }
                
                if(count<2)
                    return true;
            }
            
            i++;
        }
        
        return false;
	}

}
