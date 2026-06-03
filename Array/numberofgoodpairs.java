/**
 * LC #1512 - Number of Good Pairs
 * Link: https://leetcode.com/problems/number-of-good-pairs/
 * Difficulty: Easy
 * Pattern: Brute Force / Nested loops
 *
 * Approach:
 * Check every pair (i,j) where i < j
 * If nums[i] == nums[j] → increment pairs
 * Optimization: start j at i to avoid
 * checking same pair twice
 *
 * Time:  O(n²)
 * Space: O(1)
 *
 * Key insight:
 * Starting j at i instead of 0 cuts 
 * unnecessary comparisons in half.
 * i < j condition ensures we only count
 * each pair once.
 j = i se start karne pe i ke baad vale ko check kare ga no repetation
 */
class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int pairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j) {
                    pairs++;
                }
            }
        }
        return pairs;
    }
}
