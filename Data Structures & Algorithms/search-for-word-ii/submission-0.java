class TrieNode {
    public TrieNode[] links;
    public boolean isWord;

    public TrieNode() {
        links = new TrieNode[26];
        this.isWord = false;
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void set(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setWordEnd() {
        isWord = true;
    }
}

class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addAllWords(String[] words) {
        for (String word : words) {
            TrieNode temp = root;
            for (char ch : word.toCharArray()) {
                if (!temp.containsKey(ch)) {
                    temp.set(ch, new TrieNode());
                }
                temp = temp.get(ch);
            }
            temp.setWordEnd();
        }
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return node.isWord;
    }
}

class Solution {
    private Trie trie;
    private HashSet<String> result;
    private int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private void solve(char[][] board, int i, int j, TrieNode node, StringBuilder path, boolean[][] vis) {
        if (node.isWord) {
            result.add(path.toString());
        }

        int m = board.length;
        int n = board[0].length;

        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int r = dir[k][0] + i;
            int c = dir[k][1] + j;

            if (r >= 0 && c >= 0 && r < m && c < n && !vis[r][c] && node.containsKey(board[r][c])) {
                path.append(board[r][c]);
                solve(board, r, c, node.get(board[r][c]), path, vis);
                path.deleteCharAt(path.length() - 1);
            }
        }
        vis[i][j] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        trie = new Trie();
        result = new HashSet<>();
        trie.addAllWords(words);

        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (trie.root.containsKey(board[i][j])) {
                    solve(board, i, j, trie.root.get(board[i][j]), new StringBuilder().append(board[i][j]), vis);
                }
            }
        }
        return new ArrayList<>(result);
    }
}
