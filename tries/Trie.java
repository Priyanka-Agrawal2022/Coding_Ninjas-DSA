package tries;

class TrieNode {
	char data;
	boolean isTerminal;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		this.isTerminal = false;
		this.children = new TrieNode[26];
		this.childCount = 0;
	}
}

public class Trie {
	private TrieNode root;

	public Trie() {
		this.root = new TrieNode('\0');
	}

	public void add(String word) {
		addHelper(root, word);
	}

	private void addHelper(TrieNode root, String word) {
		// base case
		if (word.length() == 0) {
			root.isTerminal = true;
			return;
		}

		// small step
		char ch = word.charAt(0);
		int childIndex = ch - 'A'; // 'A'-'A'=0, 'B'-'A'=1
		TrieNode child = root.children[childIndex];

		if (child == null) {
			child = new TrieNode(ch);
			root.children[childIndex] = child;
			root.childCount++;
		}

		// recursive call
		addHelper(child, word.substring(1));
	}

	private boolean searchHelper(TrieNode root, String word) {
		// base case
		if (word.length() == 0)
			return root.isTerminal;
		
		// small step
		char ch = word.charAt(0);
		int childIndex = ch - 'A';
		TrieNode child = root.children[childIndex];

		if (child == null)
			return false;

		// recursive call
		return searchHelper(child, word.substring(1));
	}

	public boolean search(String word) {
		return searchHelper(root, word);
	}
	
	private void removeHelper(TrieNode root, String word) {
		//base case
		if(word.length() == 0) {
			root.isTerminal = false;
			return;
		}
		
		//small step
		char ch = word.charAt(0);
		int childIndex = ch - 'A';
		TrieNode child = root.children[childIndex];

		if (child == null)
			return;
		
		removeHelper(child, word.substring(1));
		
		if(!child.isTerminal && child.childCount == 0) {
			root.children[childIndex] = null;
			root.childCount--;
		}
	}
	
	public void remove(String word) {
		removeHelper(root, word);
	}
}
