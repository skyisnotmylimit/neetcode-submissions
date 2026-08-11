class TrieNode {
    private TrieNode[] links;
    private boolean isWord;
    public TrieNode() {
        links = new TrieNode[26];
        isWord = false;
    }
    public boolean isWordEnd() {
        return isWord;
    }
    public void setWordEnd() {
        isWord = true;
    }
    public boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }
    public TrieNode getNode(char ch) {
        return links[ch - 'a'];
    }
    public void setNode(char ch,TrieNode node) {
        links[ch - 'a'] = node;
    }
}
class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode temp = root;
        for(char ch : word.toCharArray()) {
            if(!temp.containsKey(ch)) {
                temp.setNode(ch,new TrieNode());
            }
            temp = temp.getNode(ch);
        }
        temp.setWordEnd();
    }
    public boolean search(String word) {
        TrieNode temp = root;
        for(char ch : word.toCharArray()) {
            if(!temp.containsKey(ch)) {
                return false;
            }
            temp = temp.getNode(ch);
        }
        return temp.isWordEnd();
    }
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(char ch : prefix.toCharArray()) {
            if(!temp.containsKey(ch)) {
                return false;
            }
            temp = temp.getNode(ch);
        }
        return true;
    }
}
