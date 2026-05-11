/**
 * LC #1480 - Running Sum of 1D Array
 * Link: https://leetcode.com/problems/running-sum-of-1d-array/
 * Difficulty: Easy
 * Pattern: Prefix Sum
 *
 * Approach:
 * Modify array in place.
 * For each index i, add previous element to current.
 * nums[i] = nums[i] + nums[i-1]
 * Start at i=1 — nums[0] never changes.
 *
 * Time:  O(n)
 * Space: O(1) — modifying input array in place
 *
 * Key insight: i is the position, nums[i] is the value.
 * Never add indices — always add values.
 *
 * Lesson learned:
 * i + (i-1) adds index numbers — WRONG
 * nums[i] + nums[i-1] adds values — CORRECT
 */
class RunningSum {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}
