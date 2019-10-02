package camusbai.leetcode.DP;

/**
 * Created by camusbai on 9/10/16.
 */
public class Problem334_IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;

        int[] cnt = new int[nums.length];
        cnt[cnt.length - 1] = 1;
        for (int i = nums.length - 2; i > -1; i--) {
            int idxSuccessor = i;

            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] < nums[j] && cnt[j] > cnt[idxSuccessor])
                    idxSuccessor = j;

            cnt[i] = cnt[idxSuccessor] + 1;
            if (cnt[i] == 3)
                return true;
        }
        return false;
    }
}
