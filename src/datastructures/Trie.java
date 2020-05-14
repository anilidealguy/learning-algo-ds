package datastructures;

import java.util.HashMap;
import java.util.Map;

class Trie {
	private Map<Character, Trie> nodes;
	private boolean isWord = false;

    /** Initialize your data structure here. */
    public Trie() {
        nodes = new HashMap<>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	Trie curr = this;
        for(Character ch : word.toCharArray()) {
        	Trie n = curr.nodes.get(ch);
        	
        	if (n == null) {
        		n = new Trie();
        		n.isWord = false;
        		curr.nodes.put(ch, n);
        	}
        	
        	curr = n;
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	Trie curr = this;
    	
    	for (Character ch : word.toCharArray()) {
    		Trie n = curr.nodes.get(ch);
    		
    		if (n == null)		return false;
    		
    		curr = n;
    	}
    	
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	Trie curr = this;
    	
    	for (Character ch : prefix.toCharArray()) {
    		Trie n = curr.nodes.get(ch);
    		
    		if (n == null)		return false;
    		
    		curr = n;
    	}
    	
    	return curr.isWord || curr.nodes.keySet().size() > 0;
    }
}
