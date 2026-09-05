/**
 * LC #75 - Sort Colors
 * Link: https://leetcode.com/problems/sort-colors/
 * Difficulty: Medium
 * Pattern: Dutch National Flag — three pointers
 *
 * Approach:
 * Three pointers — low, mid, high.
 * low = boundary of 0s
 * mid = current element
 * high = boundary of 2s
 *
 * if nums[mid] == 0 → swap with low, low++, mid++
 * if nums[mid] == 1 → mid++ (already in place)
 * if nums[mid] == 2 → swap with high, high--
 *                     (don't mid++ — swapped element unchecked)
 *
 * Time:  O(n)
 * Space: O(1)
 *
 * Key insight:
 * When swapping with high → don't increment mid
 * The swapped element from high is unchecked.
 * When swapping with low → increment both low and mid
 * because low region only has 0s already checked.
 *
 * Common mistakes fixed:
 * n → nums.length
 * swap() doesn't exist in Java — write manually
 * Missing if condition before first swap
 * Extra ] bracket typo
 */
class SortColors {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
