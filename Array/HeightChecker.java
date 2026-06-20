/**
 * LC #1051 - Height Checker
 * Link: https://leetcode.com/problems/height-checker/
 * Difficulty: Easy
 * Pattern: Sorting + Comparison
 *
 * Approach:
 * Clone the array to preserve original.
 * Sort the cloned array.
 * Compare original vs sorted at each index.
 * Count mismatches.
 *
 * Time:  O(n log n) — due to sorting
 * Space: O(n) — cloned array
 *
 * Key insight:
 * heights.clone() creates a separate copy
 * so original array stays unmodified.
 * Arrays.sort() sorts in place.
 */
class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        java.util.Arrays.sort(expected);
        int notMatch = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                notMatch++;
            }
        }
        return notMatch;
    }
}
