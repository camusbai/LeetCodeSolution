package camusbai.leetcode.arraylist;

import java.util.Map;
import java.util.TreeMap;

public class Problem121_BestTimeToBuyStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price < min) {
                min = price;
            } else {
                int newProfit = price - min;
                profit = newProfit > profit ? newProfit : profit;
            }
        }


        Map<String, String> map = new TreeMap<String, String>();

        return profit;
    }
}
