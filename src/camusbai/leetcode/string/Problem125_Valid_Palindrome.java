package camusbai.leetcode.string;

public class Problem125_Valid_Palindrome {

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";

        System.out.println(new Problem125_Valid_Palindrome().isPalindrome(input));
    }

    public boolean isPalindrome(String s) {
        if(s==null||s.equals("")){
            return true;
        }

        int i = 0, j = s.length() - 1;
        char[] input = s.toCharArray();
        while (i < j) {
            char leftPtr = input[i];
            char rightPtr = input[j];
            if (!shouldCompare(leftPtr)) {
                i++;
                continue;
            }
            if (!shouldCompare(rightPtr)) {
                j--;
                continue;
            }

            if (shouldCompare(leftPtr) && shouldCompare(rightPtr)) {
                if (Character.toLowerCase(leftPtr) != Character.toLowerCase(rightPtr)) {
                    return false;
                }
                i++;j--;
            }
        }
        return true;
    }

    private boolean shouldCompare(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
