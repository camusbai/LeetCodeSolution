package camusbai.leetcode.array;

import java.util.Arrays;

/**Two Sum
 *Given an array of integers, find two numbers such that they add up to a specific target number
 */
public class Problem1_TwoSum {
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int[] result = twoSum(numbers, 9);
        System.out.println(result);
    }

    public static int[] twoSum(int[] numbers, int target) {
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
