/**
 * LC #1365 - How Many Numbers Are Smaller Than the Current Number
 * Link: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * Difficulty: Easy
 * Pattern: Brute Force / Nested loops
 *
 * Approach:
 * For every element — count how many other
 * elements are strictly smaller than it.
 * Store count in result array.
 *
 * Time:  O(n²)
 * Space: O(n) — result array
 *
 * Key insight:
 * j != i avoids comparing element with itself.
 * nums[j] < nums[i] strictly less than — not <=

 */
class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i] && j != i) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}
