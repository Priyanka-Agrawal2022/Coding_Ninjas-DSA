package stacks;

import java.util.Scanner;
import java.util.Stack;

public class BracketsBalanced {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an expression: ");
		String str = sc.next();

		System.out.println(isBalance(str));
	}

	private static boolean isBalance(String str) {
		int n = str.length();
		Stack<Character> s = new Stack<>();
		int i = 0;

		for (i = 0; i < n; i++) {
			char ch = str.charAt(i);

			if (ch == '(' || ch == '{' || ch == '[')
				s.push(ch);
			else if ((ch == ')' || ch == '}' || ch == ']')) {
				if (s.isEmpty())
					break;
				else if ((ch == ')' && s.pop().equals('(')))
					continue;
				else if ((ch == '}' && s.pop().equals('{')))
					continue;
				else if ((ch == ']' && s.pop().equals('[')))
					continue;
				else
					return false;
			}
		}

		if (s.isEmpty() && i == n)
			return true;
		else
			return false;
	}

}
