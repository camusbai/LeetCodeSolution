package camusbai.leetcode.string;

/**
 * Created by camusbai on 5/9/18.
 */
public class Problem28_strStr {
        public int strStr(String haystack, String needle) {
            if (haystack == null || haystack.isEmpty()) {
                return -1;
            } else if (needle == null || needle.isEmpty()) {
                    return 0;
            } else if (needle.length() > haystack.length()) {
                return -1;
            } else {
                return haystack.indexOf(needle);
            }

    }
}
