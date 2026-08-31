/**
 * LC #410 - Split Array Largest Sum
 * Link: https://leetcode.com/problems/split-array-largest-sum/
 * Difficulty: Hard
 * Pattern: Binary Search on Answer
 *
 * Approach:
 * Binary search on the answer (the minimum largest sum).
 * low = max element (minimum possible largest sum)
 * high = total sum (maximum possible largest sum)
 *
 * For each mid — check if array can be split into
 * at most k subarrays where each sum <= mid.
 * If yes → try smaller (high = mid-1)
 * If no  → need larger (low = mid+1)
 *
 * Time:  O(n log(sum))
 * Space: O(1)
 *
 * Key insight:
 * low = max(nums) — even one element per subarray
 *       needs at least max element as limit
 * high = sum(nums) — entire array as one subarray
 * countSubarrays helper greedily packs elements
 * into subarrays without exceeding maxSum
 *
 * Learned with video help — concept took 2 hours
 * Same pattern as: Koko Eating Bananas, Capacity to Ship
 */
class SplitArrayLargestSum {
    private int countSubarrays(int[] nums, int maxSum) {
        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num <= maxSum) {
                currentSum += num;
            } else {
                subarrays++;
                currentSum = num;
            }
        }
        return subarrays;
    }

    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int subarrays = countSubarrays(nums, mid);

            if (subarrays > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
