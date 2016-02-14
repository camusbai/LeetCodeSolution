package camusbai.leetcode.array;

import camusbai.leetcode.util.Utils;

/**
 * 4. Median of Two Sorted Arrays
 * <p/>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class Problem4_MedianOfTwoArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 4, 6, 7};
        int[] nums2 = new int[]{2, 4};

        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double medianA = 0, medianB = 0;
        boolean combined1, combined2;
        combined1 = nums1.length % 2 == 0;
        combined2 = nums2.length % 2 == 0;

        // edge cases when some array is empty
        if (nums1.length == 0 && nums2.length == 0)
            return 0;
        else if (nums1.length == 0)
            return Utils.getMedian(nums2);
        else if (nums2.length == 0)
            return Utils.getMedian(nums1);

        // finding median idx in combined array
        int medianIdx = Utils.getMidIndex(0, nums1.length + nums2.length - 1);
        int i = 0, j = 0;
        while (i + j + 1 <= medianIdx) {
            if (i != nums1.length - 1 && j != nums2.length - 1) {
                if (nums1[i] <= nums2[j])
                    i++;
                if (nums1[i] > nums2[j])
                    j++;
            } else if (i == nums1.length - 1) {
                j++;
            } else if (j == nums2.length - 1) {
                i++;
            }
        }
        medianA = Math.max(nums1[i], nums2[j]);

        if (combined1 ^ combined2) {
            return medianA;
        } else {
            if(nums1[i]==medianA)
                medianB = findMedianB(nums1, i, nums2[j+1]);
            else if(nums2[j]==medianA)
                medianB = findMedianB(nums2, j, nums1[i+1]);
            return (medianA + medianB) / 2.0;
        }
    }

    private static int findMedianB(int[] A, int i, int candidateB) {
        int medianB;
        if (i != A.length - 1)
            medianB = Math.min(A[i + 1], candidateB);
        else
            medianB = candidateB;
        return medianB;
    }


}
