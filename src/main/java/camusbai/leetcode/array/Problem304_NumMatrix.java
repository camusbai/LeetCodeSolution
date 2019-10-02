package camusbai.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by camusbai on 9/4/16.
 */
public class Problem304_NumMatrix {
    private int[][] matrix;
    int[][] processedMatrix;
    private Map<String, Integer> cache = new HashMap<>();

    public Problem304_NumMatrix() {
    }

    public Problem304_NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        processedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 && j == 0) {
                    processedMatrix[i][j] = matrix[i][j];
                    continue;
                }
                if (i == 0)
                    processedMatrix[i][j] = matrix[i][j] + processedMatrix[i][j - 1];
                else if (j == 0)
                    processedMatrix[i][j] = matrix[i][j] + processedMatrix[i - 1][j];
                else
                    processedMatrix[i][j] = matrix[i][j] + processedMatrix[i - 1][j] + processedMatrix[i][j - 1] - processedMatrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0)
            return processedMatrix[row2][col2];
        if (row1 == 0)
            return processedMatrix[row2][col2] - processedMatrix[row2][col1 - 1];
        else if(col1==0)
            return processedMatrix[row2][col2] - processedMatrix[row1 - 1][col2];
        else
            return processedMatrix[row2][col2] - processedMatrix[row1 - 1][col2] - processedMatrix[row2][col1 - 1] + processedMatrix[row1 - 1][col1 - 1];

    }

    public int sumRegion1(int row1, int col1, int row2, int col2) {
        String key = row1 + "," + col1 + "," + row2 + "," + col2;
        String subSet = findMostCoverage(key);

        if (key.equals(subSet))
            return cache.get(key);

        int[] coordinate = arrayStringToInteger(subSet.split(","));
        int top = sumRectangle(row1, col1, coordinate[2] - 1, col2);
        int left = sumRectangle(Math.max(row1, coordinate[0]), col1, Math.min(row2, coordinate[2]), coordinate[1] - 1);
        int bot = sumRectangle(coordinate[2] + 1, col1, row2, col2);
        int right = sumRectangle(Math.max(row1, coordinate[0]), coordinate[3] + 1, Math.min(row2, coordinate[2]), col2);

        return top + left + bot + right + cache.get(key);
    }

    private String findMostCoverage(String key) {
        return "";
    }

    private int[] arrayStringToInteger(String[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            newArr[i] = Integer.parseInt(arr[i]);
        return newArr;
    }

    private int sumRectangle(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i < row2 + 1; i++) {
            for (int j = col1; j < col2 + 1; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}