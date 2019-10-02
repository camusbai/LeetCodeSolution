package camusbai.leetcode.mathematic;

/**
 * Created by camusbai on 3/9/16.
 */
public class Problem326_PowerOfThree {
    public static boolean isPowerOfThree(int n) {
        if (n == 0)
            return true;

        long powerThree = 0;
        int base = 1;
        while (powerThree < n) {
            powerThree = base*base*base;
            base++;
        }
        if(powerThree==n)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(0));
        System.out.println(isPowerOfThree(1));
        System.out.println(isPowerOfThree(2));
        System.out.println(isPowerOfThree(3));
        System.out.println(isPowerOfThree(2147483647));
    }
}
