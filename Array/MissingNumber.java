/**
 * LC #268 - Missing Number
 * Link: https://leetcode.com/problems/missing-number/
 * Difficulty: Easy
 * Pattern: Math — Gauss formula
 *
 * Approach:
 * Expected sum = n*(n+1)/2 (Gauss formula)
 * Actual sum = sum of all elements
 * Missing number = expected - actual
 *
 * Time:  O(n)
 * Space: O(1)
 *
 * Key insight:
 * Gauss formula gives sum of 0 to n instantly.
 * No sorting, no HashSet needed.
 * Most optimal solution possible.
 */
class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expected = n * (n + 1) / 2;
        int actual = 0;
        for (int i = 0; i < nums.length; i++) {
            actual += nums[i];
        }
        return expected - actual;
    }
}
