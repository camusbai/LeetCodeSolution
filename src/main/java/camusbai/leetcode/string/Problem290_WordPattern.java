package camusbai.leetcode.string;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by camusbai on 9/3/16.
 */
public class Problem290_WordPattern {
    public boolean wordPattern(String pattern, String str) {
//        String[] splits = StringUtils.split(str, ' ');
        String[] splits = str.split(" ");
        if (pattern.length() != splits.length)
            return false;

        Map<Character, String> dict = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character expr = pattern.charAt(i);
            if (!dict.containsKey(expr)) {
                if(dict.values().contains(splits[i]))
                    return false;
                dict.put(expr, splits[i]);
            } else {
                if(!dict.get(expr).equals(splits[i]))
                    return false;
            }
        }

        return true;
    }
}
