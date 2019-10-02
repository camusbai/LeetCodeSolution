package camusbai.leetcode.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Object ob1 = new Object();
        Object ob2 = new Object();

        System.out.println();
    }
}
