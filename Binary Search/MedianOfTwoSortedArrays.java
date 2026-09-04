/**
 * LC #4 - Median of Two Sorted Arrays
 * Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Difficulty: Hard
 * Pattern: Binary Search — partition
 *
 * Approach:
 * Binary search on the smaller array.
 * Find partition cut1 in nums1 and cut2 in nums2
 * such that left half of both = right half of both.
 *
 * Conditions for valid partition:
 * left1 <= right2 AND left2 <= right1
 *
 * If valid and even total → avg of max(left) and min(right)
 * If valid and odd total  → max of left elements
 *
 * If left1 > right2 → move cut1 left (high = cut1-1)
 * If left2 > right1 → move cut1 right (low = cut1+1)
 *
 * Time:  O(log(min(n1,n2)))
 * Space: O(1)
 *
 * Key insight:
 * Always binary search on smaller array.
 * Use Integer.MIN/MAX_VALUE for edge cases
 * when cut is at array boundary.
 * >> 1 is same as / 2 but slightly faster.
 *
 * Hardest binary search problem on LeetCode.
 */
class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0, high = n1;

        while (low <= high) {
            int cut1 = (low + high) >> 1;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

            if (left1 <= right2 && left2 <= right1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
}
