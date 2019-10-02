package camusbai.leetcode.string;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class Problem242_ValidAnagram {
  public static void main(String[] args) {
    System.out.println(isAnagram("anagram","nagaram"));
    System.out.println(isAnagram("act","cat"));
  }

  public static boolean isAnagram(String s, String t) {
    int[] alphMap = new int[26];

    for (char c : s.toCharArray())
      alphMap[c-'a']++;

    for (char c : t.toCharArray())
      alphMap[c-'a']--;

    for(int i : alphMap)
      if(i!=0)
        return false;

    return true;
  }
}