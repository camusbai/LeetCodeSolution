package camusbai.leetcode.arraylist;

import java.util.*;

public class Problem692_TopKWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> {
            Integer cnt1 = o1.getValue();
            Integer cnt2 = o2.getValue();
            return cnt1.equals(cnt2) ? o1.getKey().compareTo(o2.getKey()) : -cnt1.compareTo(cnt2);
        });

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            maxHeap.offer(entry);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll().getKey());
        }

        return result;
    }

    public List<String> topKFrequent_sort(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        List<String> wordList = new ArrayList<>(count.keySet());

        Collections.sort(wordList, (w1, w2)->{
            Integer cnt1 = count.get(w1);
            Integer cnt2 = count.get(w2);
            return cnt1.equals(cnt2) ? w1.compareTo(w2) : -cnt1.compareTo(cnt2);
        });

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(wordList.get(i));
        }

        return result;
    }
}
