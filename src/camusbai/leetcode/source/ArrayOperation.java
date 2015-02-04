package camusbai.leetcode.source;

import java.util.Arrays;

/**
 * Created by camusbai on 4/9/2014.
 */
public class ArrayOperation {
  //There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
  public double findMedianSortedArrays(int A[], int B[]) {
    int startA=0, endA=A.length-1, startB=0, endB=B.length-1;
    while(startA<endA||startB<endB) {
      int midA = getMidIndex(startA, endA);
      int midB = getMidIndex(startB, endB);
      if(A[midA] < B[midB]) {
        startA = midA;
        endB = midB;
      }
    }
    return 0.0;
  }

  private int getMidIndex(int start, int end){
    if(start>end)
      throw new IndexOutOfBoundsException("start can't be greater than end");
    int cnt = end-start+1;
    if(cnt%2==0){
      return cnt/2-1;
    }
    else{
      return cnt/2;
    }
  }//tmpdf

  /**
   * You are given an n x n 2D matrix representing an image.
   * Rotate the image by 90 degrees (clockwise).
   */
  public void rotate(int[][] matrix) {
    if(matrix==null) return;
    int n = matrix[0].length;
    for(int y=0; y<=(n-1)/2;++y){
      for(int x=y;x<=n-2-y;++x){
        int temp = matrix[x][y];
        matrix[x][y] = matrix[n-1-y][x];
        matrix[n-1-y][x] = matrix[n-1-x][n-1-y];
        matrix[n-1-x][n-1-y] = matrix[y][n-1-x];
        matrix[y][n-1-x] = temp;
      }
    }
  }

  /*Remove Duplicates from Sorted Array
    Given a sorted array, remove the duplicates in place such that each element appear only once
    and return the new length
  */
  public static int removeDuplicates(int[] A) {
    if(A.length<2) return A.length;
    int length=0,i=0,j=1;
    while(j!=A.length){
      if(A[i]!=A[j]){
        A[++i] = A[j++];
        ++length;
      }
      else if(A[i]==A[j]){
        ++j;
      }
    }
    return ++length;
  }

  /*Two Sum
    Given an array of integers, find two numbers such that they add up to a specific target number
  */
  public int[] twoSum(int[] numbers, int target) {
    int[] temp = Arrays.copyOf(numbers, numbers.length);
    Arrays.sort(temp);
    int[] rslt = new int[2];
    for (int i = 0; i < temp.length; ++i) {
      if (temp[i] > target) break;
      else {
        int remainder = target - temp[i];
        for (int j = i + 1; j < temp.length; ++j) {
          if (temp[j] == remainder) {
            rslt[0] = temp[i];
            rslt[1] = temp[j];
            return getTwoIndices(numbers, rslt);
          } else if (temp[j] > remainder) break;
        }
      }
    }
    return null;
  }

  private int[] getTwoIndices(int[] holder, int[] target) {
    for (int i = 0; i < holder.length; i++) {
      if (holder[i] == target[0]) {
        target[0] = i + 1;
        break;
      }
    }
    for (int j = holder.length - 1; j > -1; j--) {
      if (holder[j] == target[1]) {
        target[1] = j + 1;
        break;
      }
    }
    Arrays.sort(target);
    return target;
  }

  /*
  * Say you have an array for which the ith element is the price of a given stock on day i.
  * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
  * */
  public int maxProfit(int[] prices) {
    int min=prices[0],max=prices[0];
    for(int i: prices){
      if(i<min)
        min = i;
      if(i>max)
        max = i;
    }
    return max - min;
  }

  /*
  * Common utilities
  * */
  private static int shiftArrayElements(int[] array, int posA, int posB, int length) {
    if(posA<posB) {
      for (int i = 0; i < length; ++i) {
        array[posA + i] = array[posB + i];
      }
      return posA-1;
    }
    return -1;
  }

}
