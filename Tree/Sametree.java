/**
 * LC #404 - Sum of Left Leaves
 * Link: https://leetcode.com/problems/sum-of-left-leaves/
 * Difficulty: Easy
 * Pattern: DFS / Recursion
 *
 * Approach:
 * If root is null → return 0
 * Check if root.left is a leaf (no children) → add its value
 * Recurse on both left and right subtrees
 * Return total sum
 *
 * Time:  O(n)
 * Space: O(h)
 *
 * Key insight:
 * A left leaf is identified from the PARENT node.
 * Check root.left exists AND root.left has no children.
 * No helper function needed — clean single function solution.
 *
 * Solved 95% independently — clean logic and syntax throughout.
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null &&
            root.left.left == null &&
            root.left.right == null) {
            sum += root.left.val;
        }

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}
  
