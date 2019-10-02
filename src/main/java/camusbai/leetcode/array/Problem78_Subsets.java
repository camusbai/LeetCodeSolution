package camusbai.leetcode.array;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by camusbai on 8/30/16.
 */
public class Problem78_Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            result.add(Arrays.asList(new Integer[]{nums[i]}));
            for (int j = i + 1; j < nums.length; j++) {
                Integer[] tmp = ArrayUtils.toObject(Arrays.copyOfRange(nums, i, j + 1));
                result.add(Arrays.asList(tmp));
            }
        }
        result.add(new ArrayList<>());
        return result;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        for (List<Integer> l : result) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
}
