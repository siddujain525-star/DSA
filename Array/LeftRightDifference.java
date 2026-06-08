/**
 * LC #2574 - Left and Right Sum Differences
 * Link: https://leetcode.com/problems/left-and-right-sum-differences/
 * Difficulty: Easy
 * Pattern: Prefix Sum
 *
 * Approach:
 * Build leftSum array — sum of everything left of index i
 * Build rightSum array — sum of everything right of index i
 * answer[i] = Math.abs(leftSum[i] - rightSum[i])
 *
 * Time:  O(n)
 * Space: O(n)
 *
 * Key insight:
 * leftSum[0] = 0 — nothing left of first element
 * rightSum[n-1] = 0 — nothing right of last element
 * leftSum[i] = leftSum[i-1] + nums[i-1]
 * rightSum[i] = rightSum[i+1] + nums[i+1]
 *
 * Same prefix sum pattern as LC #724 Pivot Index
 * but building both directions explicitly.
 */
class LeftRightDifference {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        leftSum[0] = 0;
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }

        rightSum[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return answer;
    }
}
