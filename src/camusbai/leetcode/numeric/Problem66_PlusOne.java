package camusbai.leetcode.numeric;

import java.util.Arrays;

/**
 * Created by camusbai on 3/8/16.
 */
public class Problem66_PlusOne {
    public static int[] plusOne(int[] digits) {
        int add = 1, idx = digits.length-1;
        while (idx>-1) {
            if (digits[idx] < 9) {
                digits[idx] += add;
                break;
            } else {
                digits[idx] = 0;
                if(idx>0)
                    idx--;
                else{
                    int[] newDigits = new int[digits.length + 1];
                    newDigits[0] = 1;
                    System.arraycopy(digits,0,newDigits,1,digits.length);
                    return newDigits;
                }
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9};

        System.out.println(Arrays.toString(plusOne(digits)));

    }
}
