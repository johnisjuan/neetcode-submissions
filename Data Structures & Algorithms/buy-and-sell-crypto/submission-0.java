class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int l = 0;
        int r = 1;

        while (r < prices.length) {
            if (prices[r] < prices[l]) {
                l = r;
            } else {
                int profit = prices[r] - prices[l];
                res = Math.max(res, profit);
            }

            r++;
        }

        return res;
    }
}