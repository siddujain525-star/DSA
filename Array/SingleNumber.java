/**
 * LC #136 - Single Number
 * Link: https://leetcode.com/problems/single-number/
 * Difficulty: Easy
 * Pattern: XOR Bitwise operator
 *
 * Approach:
 * XOR all numbers together.
 * Pairs cancel out (a^a=0).
 * Only single number remains.
 *
 * Time:  O(n)
 * Space: O(1)
 *
 * Key insight:
 * a ^ a = 0 → same numbers cancel
 * a ^ 0 = a → zero has no effect
 * XOR all → pairs cancel → single remains
 *
 * Common mistake fixed:
 * Start loop at i=0 not i=1
 * i=1 misses nums[0] entirely
 *
 * Rule to remember:
 * Start at i=0 UNLESS you need nums[i-1]
 * Only then start at i=1
 */
class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
