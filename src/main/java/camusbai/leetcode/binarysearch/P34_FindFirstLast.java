package camusbai.leetcode.binarysearch;

import java.util.Arrays;

public class P34_FindFirstLast {
    public static void main(String[] args) {
        int[] input = new int[]{5, 7, 7, 8, 8, 10};
        P34_FindFirstLast main = new P34_FindFirstLast();
        int[] result = main.searchRange(input, 6);
        System.out.println(Arrays.toString(result));
    }

    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] firstAndLast = new int[]{-1, -1};

        if (nums != null && nums.length > 0) {
            binarySearch(nums, target, start, end, firstAndLast);
        }

        return firstAndLast;
    }

    private void binarySearch(int[] nums, int target, int start, int end, int[] firstAndLast) {
        if (nums[start] <= target && nums[end] >= target) {
            if (start == end) {
                updateBoundary(firstAndLast, start);
                return;
            }

            int mid = (start + end) / 2;

            if (nums[mid] >= target) {
                binarySearch(nums, target, start, mid, firstAndLast);
            }
            if (nums[mid] <= target) {
                binarySearch(nums, target, mid + 1, end, firstAndLast);
            }
        }
    }

    private void updateBoundary(int[] firstAndLast, int newPos) {
        if (firstAndLast[0] == -1) {
            firstAndLast[0] = newPos;
            firstAndLast[1] = newPos;
        } else if (newPos < firstAndLast[0]) {
            firstAndLast[0] = newPos;
        } else if (newPos > firstAndLast[1]) {
            firstAndLast[1] = newPos;
        }
    }
}
