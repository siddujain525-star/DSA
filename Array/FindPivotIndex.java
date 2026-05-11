/**
 * LC #724 - Find Pivot Index
 * Link: https://leetcode.com/problems/find-pivot-index/
 * Difficulty: Easy
 * Pattern: Prefix Sum
 *
 * Approach:
 * Calculate total sum first.
 * Loop through array tracking leftSum.
 * rightSum = totalSum - leftSum - nums[i]
 * If leftSum == rightSum → pivot found.
 *
 * Time:  O(n)
 * Space: O(1)
 *
 * Key insight: Don't need two arrays.
 * Just two variables — leftSum and rightSum.
 * rightSum = totalSum - leftSum - nums[i]
 *
 * Lesson learned:
 * When you think you need an array for running
 * calculations — try a simple variable first.
 */
class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum = totalSum + nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum = leftSum + nums[i];
        }
        return -1;
    }
}
