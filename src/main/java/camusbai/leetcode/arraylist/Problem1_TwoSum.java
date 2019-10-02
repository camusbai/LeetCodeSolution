package camusbai.leetcode.arraylist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**Two Sum
 *Given an arraylist of integers, find two numbers such that they add up to a specific target number
 */
public class Problem1_TwoSum {
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int[] result = twoSum1(numbers, 9);
        System.out.println(result);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> visitedNum = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int otherNum = target - nums[i];
            if (visitedNum.containsKey(otherNum)) {
                result[0] = visitedNum.get(otherNum);
                result[1] = i;
                break;
            }
            visitedNum.put(nums[i], i);
        }
        return result;
    }

    public static int[] twoSum1(int[] numbers, int target) {
        int[] temp = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(temp);
        int[] rslt = new int[2];
        for (int i = 0; i < temp.length; ++i) {
            if (temp[i] > target) break;
            else {
                int remainder = target - temp[i];
                for (int j = i + 1; j < temp.length; ++j) {
                    if (temp[j] == remainder) {
                        rslt[0] = temp[i];
                        rslt[1] = temp[j];
                        return getTwoIndices(numbers, rslt);
                    } else if (temp[j] > remainder) break;
                }
            }
        }
        return null;
    }

    private static int[] getTwoIndices(int[] holder, int[] target) {
        for (int i = 0; i < holder.length; i++) {
            if (holder[i] == target[0]) {
                target[0] = i + 1;
                break;
            }
        }
        for (int j = holder.length - 1; j > -1; j--) {
            if (holder[j] == target[1]) {
                target[1] = j + 1;
                break;
            }
        }
        Arrays.sort(target);
        return target;
    }
}
