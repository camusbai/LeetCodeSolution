package camusbai.leetcode.dbfs;

import java.util.*;

public class Problem127_wordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> dict = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(new Problem127_wordLadder().ladderLength(beginWord, endWord, dict));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> shrinkingDict = new LinkedList<>(wordList);
        Queue<String> q = new LinkedList<>();

        q.offer(beginWord);
        q.offer(null);
        int level = 1;

        while (!q.isEmpty()) {
            String elem = q.poll();
            if (elem == null) {
                level++;
                if (!q.isEmpty()) {
                    q.offer(null);
                }
                continue;
            }

            Iterator<String> iter = shrinkingDict.iterator();
            while (iter.hasNext()) {
                String word = iter.next();
                if (transformable(elem, word)) {
                    if (word.equals(endWord)) {
                        return level + 1;
                    }
                    q.offer(word);
                    iter.remove();
                }
            }
        }

        return 0;
    }

    private boolean transformable(String word, String target) {
        if (word == null || target == null || word.length() != target.length()) {
            return false;
        }

        boolean foundDiff = false;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                if (foundDiff) {
                    return false;
                } else {
                    foundDiff = true;
                }
            }
        }

        return foundDiff;
    }
}
