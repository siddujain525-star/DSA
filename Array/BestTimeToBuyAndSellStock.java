/**
 * LC #121 - Best Time to Buy and Sell Stock
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Difficulty: Easy
 * Pattern: Greedy / Single pass
 *
 * Approach:
 * Track two things as you loop:
 * 1. Minimum price seen so far
 * 2. Maximum profit seen so far
 * For every price — update minPrice if lower,
 * then check if current profit beats maxProfit.
 *
 * Time:  O(n)
 * Space: O(1)
 *
 * Key insight: Two separate if statements — not else if.
 * Every element must check both conditions independently.
 * Never update profit before updating minPrice.
 */
class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            }
            if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
