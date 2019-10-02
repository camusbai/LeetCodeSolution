package camusbai.leetcode.array;

import camusbai.leetcode.tag.FindLargest;

public class Problem747_LargestNumberTwice implements FindLargest {
    public static int dominantIndex(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secLargest = Integer.MIN_VALUE;
        int idx=-1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>=largest){
                secLargest = largest;
                largest = nums[i];
                idx=i;
            } else if(nums[i]>=secLargest){
                secLargest = nums[i];
            }
        }

        if(largest>=secLargest*2){
            return idx;
        } else{
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{0,0,1,2}));
    }
}
