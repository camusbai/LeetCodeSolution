package camusbai.leetcode.arraylist;

/**Remove Duplicates from Sorted Array
 * Given a sorted arraylist, remove the duplicates in place such that each element appear only once
 * and return the new length
 */
public class Problem26_RemoveDupSortedArray {
    public static int removeDuplicates(int[] A) {
        if (A.length < 2) return A.length;
        int length = 0, i = 0, j = 1;
        while (j != A.length) {
            if (A[i] != A[j]) {
                A[++i] = A[j++];
                ++length;
            } else if (A[i] == A[j]) {
                ++j;
            }
        }
        return ++length;
    }
}
