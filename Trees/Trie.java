/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

import java.util.HashMap;
import java.util.Map;

class TrieNode {

    char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isLeaf;

    public TrieNode() {
    }

    public TrieNode(char c) {
        this.c = c;
    }
}

public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
// Inserts a word into the trie.

    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
                children = t.children;
//set leaf node
                if (i == word.length() - 1) {
                    t.isLeaf = true;
                }
            }
        }
    }
    // Returns if the word is in the trie.

    public boolean search(String word) {
        TrieNode t = searchNode(word);
        return t != null && t.isLeaf;
    }
// Returns if there is any word in the trie
// that starts with the given prefix.

    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    public TrieNode searchNode(String str) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }
        return t;
    }

    public boolean dfsSearch(HashMap<Character, TrieNode> children, String word, int start) {
        if (start == word.length()) {
            return children.isEmpty();
        }
        char c = word.charAt(start);
        if (children.containsKey(c)) {
            if (start == word.length() - 1 && children.get(c).isLeaf) {
                return true;
            }
            return dfsSearch(children.get(c).children, word, start + 1);
        } else if (c == '.') {
            boolean result = false;
            for (Map.Entry<Character, TrieNode> child : children.entrySet()) {
                if (start == word.length() - 1 && child.getValue().isLeaf) {
                    return true;
                }
//if any path is true, set result to be true;
                if (dfsSearch(child.getValue().children, word, start + 1)) {
                    result = true;
                }
            }
            return result;
        } else {
            return false;
        }
    }
}
