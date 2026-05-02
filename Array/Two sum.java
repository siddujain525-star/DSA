/**
 * LC #1 - Two Sum
 * Link: https://leetcode.com/problems/two-sum/
 * Difficulty: Easy
 * Pattern: Brute Force
 *
 * Approach:
 * Two loops checking every pair of numbers.
 * If nums[i] + nums[j] == target, return indices.
 *
 * Time:  O(n²)
 * Space: O(1)
 *
 * Key insight: inner loop must increment j not i.
 */
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
