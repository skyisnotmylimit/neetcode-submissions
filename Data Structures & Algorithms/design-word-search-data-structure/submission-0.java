class TrieNode {
    private TrieNode[] links;
    private boolean isEnd;
    TrieNode() {
        links = new TrieNode[26];
        isEnd = false;
    }
    public TrieNode getKey(char ch) {
        return links[ch - 'a'];
    }
    public boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }
    public void setKey(char ch,TrieNode node) {
        links[ch - 'a'] = node;
    }
    public boolean isWordEnd() {
        return isEnd;
    }
    public void setWordEnd(boolean toBeSet) {
        isEnd = toBeSet;
    }
    public TrieNode[] getLinks() {
        return links;
    }
}
class Trie {
    private TrieNode root;
    Trie() {
        root = new TrieNode();
    }
    public void addToTrie(String word) {
        TrieNode temp = root;
        for(char ch : word.toCharArray()) {
            if(!temp.containsKey(ch)) {
                temp.setKey(ch,new TrieNode());
            }
            temp = temp.getKey(ch);
        }
        temp.setWordEnd(true);
    }
    public boolean dfs(TrieNode root, String word, int indx) {
        if (indx >= word.length()) {
            return root.isWordEnd();
        }
        char ch = word.charAt(indx);
        if (ch != '.') {
            if (root.containsKey(ch)) {
                return dfs(root.getKey(ch), word, indx + 1);
            } else {
                return false;
            }
        } else {
            for (char c = 'a'; c <= 'z'; c++) {
                if (root.containsKey(c)) {
                    if (dfs(root.getKey(c), word, indx + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    public boolean searchInTrie(String word) {
        // TrieNode temp = root;
        // for(char ch : word.toCharArray()) {
        //     if(!temp.containsKey(ch)) {
        //         return false;
        //     }
        //     temp = temp.getKey(ch);
        // }
        // return temp.isWordEnd();
        TrieNode temp = root;
        return dfs(temp,word,0);
    }
}
class WordDictionary {
    private Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.addToTrie(word);
    }

    public boolean search(String word) {
        return trie.searchInTrie(word);
    }
}
