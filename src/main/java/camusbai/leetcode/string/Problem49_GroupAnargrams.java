package camusbai.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by camusbai on 8/29/16.
 */
public class Problem49_GroupAnargrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> dict = new HashMap<>();
        for (String word : strs) {
            int[] charCount = charCount(word);
            String key = reconstructWord(charCount);
            if (dict.containsKey(key)) {
                dict.get(key).add(word);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(word);
                dict.put(key, list);
            }
        }
        for (Map.Entry<String, List<String>> entry : dict.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private int[] charCount(String word) {
        int[] chars = new int[26];

        for (int i = 0; i < word.length(); i++)
            chars[word.charAt(i) - 'a']++;

        return chars;
    }

    private String reconstructWord(int[] charCount) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while (charCount[i] > 0) {
                builder.append(i + 'a');
                charCount[i]--;
            }
        }
        return builder.toString();
    }
}
