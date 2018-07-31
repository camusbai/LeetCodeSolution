package camusbai.leetcode.arraylist;

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
public class Problem303_RangeSumQuery {
  private final int[] sums;

  public static void main(String[] args) {
    int[] nums = {-2, 0, 3, -5, 2, -1};
    Problem303_RangeSumQuery query = new Problem303_RangeSumQuery(nums);
    System.out.println(query.sumRange(0, 2));
    System.out.println(query.sumRange(2, 5));
    System.out.println(query.sumRange(0, 5));
  }

  public Problem303_RangeSumQuery(int[] nums) {
    sums = nums;
    for (int i = 1; i < nums.length; ++i)
      sums[i] += sums[i - 1];
  }

  public int sumRange(int i, int j) {
    return i == 0 ? sums[j] : sums[j] - sums[i - 1];
  }
}

