package camusbai.leetcode.arraylist;

import camusbai.leetcode.util.Utils;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 */
public class Problem48_RotateImage {
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.print("Original Matrix:");
        Utils.printMatrix(matrix, 4, 4);
        System.out.println("Rotated Matrix:");
        rotate(matrix);
        Utils.printMatrix(matrix,4,4);
    }
    public static void rotate(int[][] matrix) {
        if (matrix == null) return;
        int n = matrix[0].length;
        for (int y = 0; y <= (n - 1) / 2; ++y) {
            for (int x = y; x <= n - 2 - y; ++x) {
                int temp = matrix[x][y];
                matrix[x][y] = matrix[n - 1 - y][x];
                matrix[n - 1 - y][x] = matrix[n - 1 - x][n - 1 - y];
                matrix[n - 1 - x][n - 1 - y] = matrix[y][n - 1 - x];
                matrix[y][n - 1 - x] = temp;
            }
        }
    }
}
