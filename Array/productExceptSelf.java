/**
 * LC #238 - ProductExcept self
 * Link: https://leetcode.com/problems/product-of-array-except-self/
 * Difficulty: Medium
 * Pattern: prefix and Suffix pattern
 * Approach:
 * Calculate the product right side and left side :
 * 1. Calculate the sum of the left side of i
 * 2. Calculate the sum of the Right side of i
 * Time:  O(n)
 * Space: O(1)
 *
 * Key insight: assign initial as 1 so the product does not go 0 when there is nothing in the right or left side (extreme)
 * Can use 2 loops but will be O(n^2)
 * Common mistakes:
 * - Assigning an initial 0 that gives 0 if nothing is left
 */
  class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];  
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * right;  
            right = right * nums[i];     
        }
        
        return result;
    }
}
