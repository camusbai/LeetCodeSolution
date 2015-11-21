package camusbai.leetcode.source;

/**
 * Created by camusbai on 5/11/2014.
 */
public class NumericOperation {
  public int sqrt(int x) {
    return (int) Math.sqrt(x);
  }

  public static int lengthOfLIS(int[] nums) {
    int LIS = nums.length != 0 ? 1 : 0;
    for (int idx = 0; idx < nums.length - 1; idx++) {
      if(idx==2)
        System.out.println();
      int sum = 1, i = idx, j = idx + 1;
      while (j != nums.length) {
        if (nums[i] < nums[j]) {
          i = j;
          j++;
          sum++;
        } else {
          j++;
        }
      }
      LIS = sum > LIS ? sum : LIS;
    }
    return LIS;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{10, 12, 9, 2, 5, 3, 7, 101, 18,102};
    int[] arr1 = new int[]{0};
    int[] arr2 = new int[2];
    int[] arr3 = new int[]{10,9,2,5,3,4};
    System.out.print(lengthOfLIS(arr3));
  }
}
