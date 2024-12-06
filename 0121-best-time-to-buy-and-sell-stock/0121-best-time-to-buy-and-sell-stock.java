class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int maxPro = 0;

        for(int i = 1; i < prices.length; i++){
            int cost = prices[i] - mini;
            maxPro =  Math.max(cost, maxPro);
            mini = Math.min(prices[i], mini);
        }

        return maxPro;
    }
}