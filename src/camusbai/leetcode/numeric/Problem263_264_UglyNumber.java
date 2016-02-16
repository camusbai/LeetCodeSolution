package camusbai.leetcode.numeric;

/**
 * Ugly Number 1
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 *
 * Ugly Number 2
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 *
 */
public class Problem263_264_UglyNumber {
  public static void main(String[] args) {
    System.out.println(-7%5);
  }

  public boolean isUgly(int num) {
    if(num<1)
      return false;

    while(num%2==0)
      num/=2;
    while(num%3==0)
      num/=3;
    while(num%5==0)
      num/=5;

    if(num==1)
      return true;
    else
      return false;
  }

  public int nthUglyNumber(int n) {
    return 0;
  }
}
