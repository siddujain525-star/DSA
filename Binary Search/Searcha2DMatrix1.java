/**
 * LC #74 - Search a 2D Matrix
 * Link: https://leetcode.com/problems/search-a-2d-matrix/
 * Difficulty: Medium
 * Pattern: Binary Search on 2D matrix
 *
 * Approach:
 * Treat entire matrix as flattened 1D sorted array.
 * Total elements = n * m
 * For any mid index:
 *   row = mid / m
 *   col = mid % m
 * Apply standard binary search on this virtual array.
 *
 * Time:  O(log(n*m))
 * Space: O(1)
 *
 * Key insight:
 * matrix[0].length gives columns — not matrix.length
 * matrix.length gives rows only
 * while(low <= high) not low < high — covers equal case
 *
 * Common mistakes fixed:
 * semicolon after if kills the block
 * elseif → else if in Java
 * matrix.length - 1 ≠ number of columns
 */
class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / m;
            int col = mid % m;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
