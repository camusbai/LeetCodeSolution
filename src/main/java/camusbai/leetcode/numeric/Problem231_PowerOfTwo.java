package camusbai.leetcode.numeric;

import camusbai.leetcode.global.Solution;
import camusbai.leetcode.util.Utils;

/**
 * Created by camusbai on 2/15/2016.
 */
public class Problem231_PowerOfTwo {
  public static void main(String[] args) {
    System.out.println(isPowerOfTwo(16));
    System.out.println(-1%2);
    System.out.println(Utils.getBitExpression(4294967296L));
  }

  public static boolean isPowerOfTwo(int n) {
    Solution sol = Solution.MINE;
    switch (sol) {
      case MINE:
        if (n < 1)
          return false;

        while ((n & 1) == 0)
          n = n >> 1;
        n = n >> 1;

        return n == 0;
      case BETTER:
        return (n > 0) && ((n & n - 1) == 0);
      default:
        return false;
    }
  }
}
