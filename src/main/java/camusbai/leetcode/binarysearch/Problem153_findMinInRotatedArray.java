package camusbai.leetcode.binarysearch;

public class Problem153_findMinInRotatedArray {
    public int findMin(int[] nums) {
        int[] result = new int[1];
        result[0] = Integer.MAX_VALUE;
        recursiveBinarySearch(nums, 0, nums.length-1, result);



        return result[0];
    }

    private void recursiveBinarySearch(int[] nums, int left, int right, int[] result) {
        int leftNum = nums[left];
        int rightNum = nums[right];

        if (leftNum <= rightNum) {
            result[0] = Math.min(leftNum, result[0]);
        } else if (leftNum > rightNum) {
            int mid = (left + right) / 2;
            recursiveBinarySearch(nums, left, mid, result);
            recursiveBinarySearch(nums, mid + 1, right, result);
        }
    }
}
