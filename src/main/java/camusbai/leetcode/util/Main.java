package camusbai.leetcode.util;

/**
 * Created by camusbai on 3/7/16.
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 3, 4, 4, 2},
                {1, 2, 3, 5, 5},
                {3, 4, 5, 2, 6},
                {5, 6, 6, 3, 9},
                {5, 6, 6, 3, 9}};

        int[][] matrix2 = {{1}};
        Utils.printMatrix(matrix, 5, 5);
        System.out.println();
        Utils.printMatrixSpiral(matrix);
    }
}
