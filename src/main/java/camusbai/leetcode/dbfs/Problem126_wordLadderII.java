package camusbai.leetcode.dbfs;

import java.util.*;

public class Problem126_wordLadderII {
    public static void main(String[] args) {
        String beginWord = "red";
        String endWord = "tax";
        List<String> dict = Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee");

        List<List<String>> result = new Problem126_wordLadderII().findLadders(beginWord, endWord, dict);
        for (List<String> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> shrinkingDict = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        Queue<ChainWord> chain = new LinkedList<>();

        q.offer(beginWord);
        q.offer(null);
        chain.offer(new ChainWord(beginWord, null));
        boolean found = false;
        List<List<String>> result = new ArrayList<>();

        if (!shrinkingDict.contains(endWord)) {
            return result;
        }

        while (!q.isEmpty()) {
            String elem = q.poll();

            if (elem == null) {
                if (found) {
                    break;
                }

                if (!q.isEmpty()) {
                    q.offer(null);
                }
                continue;
            }

            shrinkingDict.remove(elem);
            ChainWord chainWord = chain.poll();
            if (elem.equals(endWord)) {
                found = true;
                addToResult(chainWord, result);
                continue;
            }

            Iterator<String> iter = shrinkingDict.iterator();
            while (iter.hasNext()) {
                String word = iter.next();
                if (transformable(elem, word)) {
                    ChainWord child = new ChainWord(word, chainWord);
                    q.offer(word);
                    chain.offer(child);
                }
            }
        }

        return result;
    }

    private void addToResult(ChainWord chainWord, List<List<String>> result) {
        Stack<String> stack = new Stack<>();
        while (chainWord != null) {
            stack.push(chainWord.word);
            chainWord = chainWord.prevWord;
        }

        List<String> chain = new ArrayList<>();
        while (!stack.isEmpty()) {
            chain.add(stack.pop());
        }

        result.add(chain);
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

    static class ChainWord {
        String word;
        ChainWord prevWord;

        public ChainWord(String word, ChainWord prevWord) {
            this.word = word;
            this.prevWord = prevWord;
        }
    }

}
