/**
 * LC #485 - Max Consecutive Ones
 * Link: https://leetcode.com/problems/max-consecutive-ones/
 * Difficulty: Easy
 * Pattern: Single pass + running counter
 *
 * Approach:
 * Track current streak of consecutive 1s in count.
 * Track best streak seen so far in maxCount.
 * Reset count to 0 whenever a 0 is found.
 * Update maxCount whenever count exceeds it.
 *
 * Time:  O(n)
 * Space: O(1)
 *
 * Key insight:
 * Don't need extra arrays or sliding window here —
 * a single counter that resets on 0 is enough.
 */
class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }
        return maxCount;
    }
}
