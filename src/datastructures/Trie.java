package datastructures;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	private Trie[] nodes;
	public boolean isWord = false;

	/** Initialize your data structure here. */
	public Trie() {
		nodes = new Trie[26];
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Trie curr = this;
		for(Character ch : word.toCharArray()) {
			Trie n = curr.nodes[ch - 'a'];
			
			if (n == null) {
				n = new Trie();
				n.isWord = false;
				curr.nodes[ch - 'a'] = n;
			}
			
			curr = n;
		}
		curr.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Trie curr = this;
		
		for (Character ch : word.toCharArray()) {
			Trie n = curr.nodes[ch];
			
			if (n == null)		return false;
			
			curr = n;
		}
		
		return curr.isWord;
	}

	public Trie startsWith(Trie curr, char prefix) {
		Trie n = curr.nodes[prefix - 'a'];
		return n;
	}
}