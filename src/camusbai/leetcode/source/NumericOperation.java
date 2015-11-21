package camusbai.leetcode.source;

/**
 * Created by camusbai on 5/11/2014.
 */
public class NumericOperation {
    public int sqrt(int x) {
        return (int) Math.sqrt(x);
    }

    /*
    * Reverse Integer
    * */
    public static int reverse(int x) {
        int rvse = 0, bit=0;
        while (x != 0) {
            if(++bit==10)
                if(rvse*10/10!=rvse)
                    return 0;
            rvse = rvse * 10 + x % 10;
            x /= 10;
        }
        return x < 0 ? -rvse : rvse;
    }

    /*
    * #300
    * */
    public int lengthOfLIS(int[] nums) {
        int LIS = 0;

        return LIS;
    }
}
