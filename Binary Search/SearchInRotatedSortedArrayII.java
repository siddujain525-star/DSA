/**
 * LC #81 - Search in Rotated Sorted Array II
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * Difficulty: Medium
 * Pattern: Binary Search with duplicates
 *
 * Approach:
 * Same as LC #33 but handles duplicates.
 * When nums[low]==nums[mid]==nums[high] → can't determine
 * which half is sorted → shrink both sides (low++, high--)
 * Then continue with normal rotated array binary search.
 *
 * Time:  O(log n) average, O(n) worst case (all duplicates)
 * Space: O(1)
 *
 * Key difference from LC #33:
 * LC #33 — no duplicates → always know sorted half
 * LC #81 — duplicates → shrink both sides when ambiguous
 *
 * Common mistakes fixed:
 * True → true (Java is lowercase)
 * high++ → high-- (shrink not expand)
 * countinue → continue (spelling)
 * return -1 → return false (boolean method)
 */
class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
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
        return false;
    }
}
