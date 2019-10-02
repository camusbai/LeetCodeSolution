package camusbai.leetcode.array;

import camusbai.leetcode.global.Solution;

/**
 * Created by camusbai on 3/6/16.
 */
public class Problem300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        Solution sol = Solution.GOOD;
        switch (sol) {
            case GOOD:
                if (nums.length == 0)
                    return 0;

                int[] longestLen = new int[nums.length];
                longestLen[0] = 1;
                for (int i = 0; i < nums.length; ++i) {
                    int lis = 0, j = i;
                    while (j-- > 0) {
                        if (nums[j] < nums[i])
                            lis = Math.max(lis, longestLen[j]);
                    }
                    longestLen[i] = ++lis;
                }

                int LIS = 0;
                for (int x : longestLen)
                    LIS = Math.max(LIS, x);

                return LIS;
        }
        return -1;
    }
}
