package camusbai.extra;

public class Knapsack {

    public static void main(String[] args) {
        System.out.println(unboundedKnapsack(4, 17, new int[]{6, 13, 7, 10, 2, 20, 1, 5, 18, 14, 3, 15, 16, 13, 12, 18, 3},
                new int[]{198, 82, 146, 199, 190, 18, 35, 84, 4, 163, 4, 51, 3, 49, 28, 20, 190}));
    }

    public static int knapsack01(int capacity, int[] weight, int[] worth) {
        return -1;
    }

    public static int unboundedKnapsack(int W, int n, int[] val, int[] wt) {

        // dp[i] is going to store maximum value
        // with knapsack capacity i.
        int dp[] = new int[W + 1];

        // Fill dp[] using above recursive formula
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j < n; j++) {
                if (wt[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }
        return dp[W];
    }
}
