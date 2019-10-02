package camusbai.leetcode.string;

/**
 * Created by camusbai on 8/30/16.
 */
public class Problem171_ExcelSheetColumnNumber {
    public static int titleToNumber(String s) {
        int base = 26, number = 0;
        for (int i = s.length() - 1; i > -1; i--)
            number += (s.charAt(i) - 'A' + 1) * Math.pow(base, s.length()-1-i);
        return number;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber(""));
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));
    }
}
