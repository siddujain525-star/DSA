/**
 * LC #153 - Find Minimum in Rotated Sorted Array
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Difficulty: Medium
 * Pattern: Binary Search on rotated array
 *
 * Approach:
 * If current subarray is sorted → minimum is leftmost element
 * If left half is sorted → minimum is in right half
 * If right half is sorted → minimum is in left half
 * Track minimum seen so far in ans
 *
 * Time:  O(log n)
 * Space: O(1)
 *
 * Key insight:
 * Check if nums[low] <= nums[high] to detect sorted subarray
 * If left sorted → ans = nums[low], move right
 * If right sorted → ans = nums[mid], move left
 *
 * Common mistakes fixed:
 * Int_MAX → Integer.MAX_VALUE
 * arr[]   → nums[]
 * min()   → Math.min()
 */
class FindMinRotatedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }
            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}
