package camusbai.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class P409_LongestPalindrome {
    //TODO improve performance
    public int longestPalindrome(String s) {
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            int cnt = count.getOrDefault(c, 0);
            count.put(c, cnt + 1);
        }

        int max = 0;
        boolean usedOdd = false;
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            int val = entry.getValue();
            if (val % 2 == 0) {
                max += val;
            } else {
                if (usedOdd) {
                    max += (val - 1);
                } else {
                    max += val;
                    usedOdd = true;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";

        new P409_LongestPalindrome().longestPalindrome(s);
    }
}
