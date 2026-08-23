/**
 * LC #34 - Find First and Last Position of Element in Sorted Array
 * Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Difficulty: Medium
 * Pattern: Binary Search — first and last occurrence
 *
 * Approach:
 * Two separate binary searches.
 * First occurrence: when found, save mid and go LEFT
 * Last occurrence: when found, save mid and go RIGHT
 *
 * Time:  O(log n)
 * Space: O(1)
 *
 * Key insight:
 * First: arr[mid]==k → first=mid, high=mid-1 (go left)
 * Last:  arr[mid]==k → last=mid, low=mid+1  (go right)
 */
class FindFirstAndLastPosition {
    private int firstOccurrence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int first = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    private int lastOccurrence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int last = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = firstOccurrence(nums, n, target);
        int last = lastOccurrence(nums, n, target);
        return new int[]{first, last};
    }
}
