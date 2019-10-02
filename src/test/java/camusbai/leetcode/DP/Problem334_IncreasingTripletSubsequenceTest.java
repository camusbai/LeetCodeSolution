package camusbai.leetcode.DP;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by camusbai on 9/10/16.
 */
public class Problem334_IncreasingTripletSubsequenceTest {
    @Test
    public void increasingTriplet() throws Exception {
        Problem334_IncreasingTripletSubsequence its = new Problem334_IncreasingTripletSubsequence();
        boolean rslt = its.increasingTriplet(new int[]{1, 2, 3, 4, 5});
        System.out.println(rslt);
    }
}