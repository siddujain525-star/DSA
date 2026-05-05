/**
 * LC #53 - Maximum Subarray
 * Link: https://leetcode.com/problems/maximum-subarray/
 * Difficulty: Easy
 * Pattern: Kadane's Algorithm
 *
 * Approach:
 * Track two variables as you loop:
 * 1. current sum — add each element, reset to 0 if negative
 * 2. max sum — update whenever current sum is greater
 *
 * Time:  O(n)
 * Space: O(1)
 *
 * Key insight: If the current sum goes negative, it can never
 * help any future subarray — reset it to 0 and start fresh.
 * This is Kadane's algorithm.
 *
 * Common mistakes:
 * - Using MIN_Value instead of MIN_VALUE (case sensitive)
 * - Redeclaring variables with int inside the loop
 * - Using n instead of nums.length
 */
class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
