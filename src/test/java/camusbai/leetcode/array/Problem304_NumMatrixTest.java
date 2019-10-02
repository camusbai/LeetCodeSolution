package camusbai.leetcode.array;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by camusbai on 9/4/16.
 */
public class Problem304_NumMatrixTest {
    int[][] matrix;

    @org.junit.Before
    public void setUp() throws Exception {
        matrix = new int[][]{
                {2, 3, 4, 3, 4},
                {2, 2, 3, 4, 5},
                {4, 3, 6, 7, 8},
                {5, 7, 8, 4, 3}};
    }

    @org.junit.Test
    public void sumRegion() throws Exception {
        Problem304_NumMatrix numMatrix = new Problem304_NumMatrix(matrix);
        System.out.println(Arrays.deepToString(numMatrix.processedMatrix));
        System.out.println(numMatrix.sumRegion(2, 2, 2, 2));
    }

}