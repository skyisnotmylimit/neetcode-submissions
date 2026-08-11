class Pair{
    String word;
    int lvl;
    Pair(String word,int lvl) {
        this.word = word;
        this.lvl = lvl;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()) {
            String currentWord = q.peek().word;
            int currentLvl = q.peek().lvl;
            q.remove();
            if(currentWord.equals(endWord)) return currentLvl;
            for(int i=0;i<currentWord.length();i++) {
                for(char c='a';c<='z';c++) {
                    char wordArray[] = currentWord.toCharArray();
                    wordArray[i] = c;
                    String convertWord = new String(wordArray);
                    if(set.contains(convertWord)) {
                        set.remove(convertWord);
                        q.add(new Pair(convertWord,currentLvl+1));
                    }
                }
            }
        }
        return 0;
    }
}