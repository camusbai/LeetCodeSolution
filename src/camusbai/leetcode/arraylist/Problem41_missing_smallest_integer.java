package camusbai.leetcode.arraylist;

public class Problem41_missing_smallest_integer {
    public static int firstMissingPositive(int[] nums) {
        int start = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num <= 0) {
                continue;
            }

            // init range points
            if (start < 0) {
                start = num;
                end = num;
                continue;
            }

            if (num < start) {
                if (num == start - 1) {
                    start = num;
                } else{
                    start = num;
                    end = num;
                }
            }else if (num > end) {
                if (num == end + 1) {
                    end = num;
                }
            }
        }

        if (start > 1) {
            return 1;
        } else {
            return end + 1;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,1,2,3};
        System.out.println(firstMissingPositive(a));
    }
}
