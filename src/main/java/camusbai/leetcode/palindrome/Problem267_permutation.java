package camusbai.leetcode.palindrome;

import java.util.*;

public class Problem267_permutation {
    public static void main(String[] args) {
        List<String> result = new Problem267_permutation().generatePalindromes01("abc");
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();

        if (s == null || s.length() < 2) {
            result.add(s);
            return result;
        }

        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        List<Character> half = new ArrayList<>();

        Character oddOne = null;
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            int quotient = entry.getValue() / 2;
            int remainder = entry.getValue() % 2;

            if (remainder == 1) {
                if (oddOne != null) {
                    return result;
                }

                oddOne = entry.getKey();
            }

            for (int i = 0; i < quotient; i++) {
                half.add(entry.getKey());
            }
        }

        Set<String> halves = new HashSet<>();
        int halfLen = half.size();

        Stack<Character> visitingStack = new Stack<>();
        Stack<List<Character>> remainingStack = new Stack<>();

        // initialization
        populateStacks(visitingStack, remainingStack, half);

        StringBuilder sb = new StringBuilder();
        while (!visitingStack.isEmpty()) {
            Character v = visitingStack.pop();
            List<Character> r = remainingStack.pop();

            if (sb.length() + 1 + r.size() > halfLen) {
                sb.delete(halfLen - r.size() - 1, halfLen);
            }

            sb.append(v);
            if (r.isEmpty()) {
                halves.add(sb.toString());
            } else {
                populateStacks(visitingStack, remainingStack, r);
            }
        }

        // build palindromes
        for (String str : halves) {
            StringBuilder permutation = new StringBuilder();

            permutation.append(str);
            if (oddOne != null) {
                permutation.append(oddOne);
            }

            for (int i = str.length() - 1; i > -1; i--) {
                permutation.append(str.charAt(i));
            }
            result.add(permutation.toString());
        }

        return result;
    }

    private static void populateStacks(Stack<Character> visitingStack, Stack<List<Character>> remainingStack, List<Character> characters) {
        for (int i = 0; i < characters.size(); i++) {
            visitingStack.push(characters.get(i));
            List<Character> chars = new ArrayList<>();
            for (int j = 0; j < characters.size(); j++) {
                if (i != j) {
                    chars.add(characters.get(j));
                }
            }
            remainingStack.push(chars);
        }
    }

    //    =============== LC solution1=================
    Set<String> set = new HashSet<>();

    public List<String> generatePalindromes01(String s) {
        permute(s.toCharArray(), 0);
        return new ArrayList<String>(set);
    }

    public boolean isPalindrome(char[] s) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] != s[s.length - 1 - i])
                return false;
        }
        return true;
    }

    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    void permute(char[] s, int l) {
        if (l == s.length) {
//            if (isPalindrome(s))
                set.add(new String(s));
        } else {
            for (int i = l; i < s.length; i++) {
                swap(s, l, i);
                permute(s, l + 1);
                swap(s, l, i);
            }
        }
    }

}
