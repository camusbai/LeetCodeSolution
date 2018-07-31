package camusbai.leetcode.backtrack;

import java.util.*;

public class Problem139_wordBreak {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> dict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        boolean result = new Problem139_wordBreak().wordBreak_BFS(s, dict);

        System.out.println(result);
    }

    public boolean wordBreak_BFS(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[s.length()+1];
        q.offer(0);
        while (!q.isEmpty()) {
            int start = q.poll();

            if (start == s.length()) {
                return true;
            }

            for (String word : wordDict) {
                if (s.startsWith(word, start) && !visited[start + word.length()]) {
                    q.offer(start + word.length());
                    visited[start + word.length()] = true;
                }
            }
        }

        return false;
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.isEmpty() || s == null || s.isEmpty()) {
            return false;
        }
        Boolean[] cache = new Boolean[s.length() + 1];
        return segment(s, 0, wordDict, cache);
    }

    private boolean segment(String s, int idx, List<String> dict, Boolean[] cache) {
        if (idx == s.length()) {
            return true;
        } else if (idx > s.length()) {
            return false;
        }

        if (cache[idx] != null) {
            return cache[idx];
        }

        boolean found = false;
        for (String word : dict) {
            if (s.startsWith(word, idx)) {
                boolean ret = segment(s, idx + word.length(), dict, cache);
                found = found | ret;
                if (found) {
                    cache[idx + word.length()] = true;
                }
            }
        }

        if (!found) {
            cache[idx] = false;
        }

        return found;
    }
}
