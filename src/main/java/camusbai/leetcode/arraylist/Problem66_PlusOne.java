package camusbai.leetcode.arraylist;

import java.util.Arrays;

public class Problem66_PlusOne {
    public int[] plusOne(int[] digits) {
        boolean carry = false;
        for(int i = digits.length-1;i>-1;i--){
            int digit = digits[i];
            if (i == digits.length - 1) {
                digit++;
            }

            if(carry){
                digit++;
                carry = false;
            }

            if(digit>9){
                digit = digit - 10;
                carry = true;
            }

            digits[i] = digit;

            if(!carry){
                break;
            }
        }

        if(carry){
            int[] newresult = new int[digits.length+1];
            newresult[0] = 1;
            System.arraycopy(digits, 0, newresult,1, digits.length);
            digits = newresult;
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] input = {9, 9};

        int[] reuslt = new Problem66_PlusOne().plusOne(input);

        System.out.println(Arrays.toString(reuslt));

    }
}
