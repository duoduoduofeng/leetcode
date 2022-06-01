package leetcodeproblems.LC_101_200;

//121. [Best Time to Buy and Sell Stock]
// (https://leetcode.com/problems/best-time-to-buy-and-sell-stock)
public class S_121_SellStock {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }

        int max_profit = 0;
        int min_ele = prices[0];

        for(int i = 1; i < prices.length; i++) {
            int cur_profit = prices[i] - min_ele;
            if(cur_profit > max_profit) {
                max_profit = cur_profit;
            }

            if(prices[i] < min_ele){
                min_ele = prices[i];
            }
        }

        return max_profit;
    }
}
