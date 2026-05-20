/**
 * LC #112 - Path Sum
 * Link: https://leetcode.com/problems/path-sum/
 * Difficulty: Easy
 * Pattern: DFS / Recursion
 *
 * Approach:
 * If root is null → return false
 * If leaf node → check if targetSum == root.val
 * Else → recurse left and right with (targetSum - root.val)
 * Return true if either path works (use ||)
 *
 * Time:  O(n)
 * Space: O(h)
 *
 * Key insight:
 * Subtract node value as you go deeper.
 * At leaf node, check if remaining sum equals leaf value.
 * || used because only ONE valid path is enough.
 *
 * Self-solve: 20% — had the right instinct (recursion + base case)
 * but syntax errors and wrong logic throughout.
 * Understood full solution after line-by-line explanation.
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
         return false;
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
          return hasPathSum(root.left, targetSum - root.val)
            || hasPathSum(root.right, targetSum - root.val);
        
    }
}
