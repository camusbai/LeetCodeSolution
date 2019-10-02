package camusbai.leetcode.array;

import java.util.Arrays;

/**
 * Created by camusbai on 2/20/2016.
 */
public class Problem27_RemoveElement {
  public static void main(String[] args) {
    int[] arr = {2,3,4,5,6,5,3,2,1};
    System.out.println(Arrays.toString(arr));
    int cnt = removeElement(arr, 2);
    System.out.println(Arrays.toString(arr));
    System.out.println(cnt);
  }

  public static int removeElement(int[] nums, int val) {
    int idx = 0;
    for (int i : nums)
      if(i!=val)
        nums[idx++] = i;
    return idx;
  }
}
