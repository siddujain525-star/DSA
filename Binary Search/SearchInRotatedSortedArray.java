/**
 * LC #33 - Search in Rotated Sorted Array
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Difficulty: Medium
 * Pattern: Binary Search on rotated array
 *
 * Approach:
 * At every mid — one half is always sorted.
 * Check which half is sorted using nums[low] <= nums[mid].
 * If left sorted → check if target in left half.
 * If right sorted → check if target in right half.
 * Move accordingly.
 *
 * Time:  O(log n)
 * Space: O(1)
 *
 * Key insight:
 * One half is ALWAYS sorted in a rotated array.
 * Identify sorted half first — then check if target is there.
 * Never try to find rotation point separately.
 *
 * Common mistakes fixed:
 * arr[] → nums[]
 * Two else blocks for one if → only one else allowed
 * return → return -1
 */
class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
