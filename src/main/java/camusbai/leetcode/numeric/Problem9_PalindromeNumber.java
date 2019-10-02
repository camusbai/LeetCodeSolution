package camusbai.leetcode.numeric;

import camusbai.leetcode.global.Solution;

/**
 * Created by camusbai on 2/18/2016.
 */
public class Problem9_PalindromeNumber {
  public static void main(String[] args) {
    System.out.println(isPalindrome(312213));
  }

  public static boolean isPalindrome(int x) {
    Solution sol = Solution.BETTER;
    switch (sol) {
      case BETTER:
        if (x < 0)
          return false;
        int y = 0, x1 = 1;
        while (x / x1 != 0) {
          y = y * 10 + x % 10;
          x /= 10;
          x1 *= 10;
        }
        return y < 10 * x ? y == x : y / 10 == x;
      case MINE:
        if (x < 0)
          return false;

        int cnt = 0;
        int tmp = x;
        while (tmp != 0) {
          tmp /= 10;
          cnt++;
        }

        for (int i = 1; i <= cnt / 2; ++i)
          if (getDigit(x, i) != getDigit(x, cnt + 1 - i))
            return false;

        return true;
      default:
        return false;
    }
  }

  /**
   * the pos of smallest digit is 1. i.e pos of 3 in 123 is 1
   */
  public static int getDigit(int x, int pos) {
    x /= (int) Math.pow(10, pos - 1);
    x %= 10;
    return x;
  }
}
