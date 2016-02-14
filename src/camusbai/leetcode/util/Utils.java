package camusbai.leetcode.util;

import camusbai.leetcode.tree.TreeNode;

/**
 * Created by camusbai on 2/13/16.
 */
public class Utils {

    public static double getMedian(int[] singleArray) {
        int mid = getMidIndex(0, singleArray.length - 1);
        if (singleArray.length % 2 == 0)
            return (singleArray[mid] + singleArray[mid + 1]) / 2.0;
        else
            return singleArray[mid];
    }

    public static int getMidIndex(int startIdx, int endIdx) {
        if (startIdx > endIdx)
            throw new IndexOutOfBoundsException("start can't be greater than end");
        int cnt = endIdx - startIdx + 1;
        if (cnt % 2 == 0) {
            return cnt / 2 - 1;
        } else {
            return cnt / 2;
        }
    }

    public void printAntiClockwise(TreeNode t, boolean pureLeft, boolean pureRight){
        if (t == null) return;

        boolean printed = false;
        if (pureLeft ||
                ((t.left == null) && (t.right == null))){
            System.out.print( Integer.toString(t.getVal())+' ');
            printed = true;
        }

        printAntiClockwise(t.left, pureLeft && true, false);

        printAntiClockwise(t.right, false, pureRight && true);

        if (pureRight && !pureLeft && !printed){
            System.out.print(Integer.toString(t.getVal())+' ');
        }
    }

    // Common utilities
    public static int shiftArrayElements(int[] array, int posA, int posB, int length) {
        if (posA < posB) {
            for (int i = 0; i < length; ++i) {
                array[posA + i] = array[posB + i];
            }
            return posA - 1;
        }
        return -1;
    }

    public static void printMatrix(int[][] matrix, int x, int y) {
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                System.out.print((String.valueOf(matrix[i][j]) + ' '));
            }
            System.out.println();
        }
    }
}