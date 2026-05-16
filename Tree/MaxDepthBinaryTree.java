/**
 * LC #104 - Maximum Depth of Binary Tree
 * Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Difficulty: Easy
 * Pattern: Tree recursion
 *
 * Approach:
 * If root is null → return 0 (base case)
 * Recurse on left and right subtrees.
 * Return 1 + max(leftDepth, rightDepth)
 *
 * Time:  O(n)
 * Space: O(h) — h is height of tree
 *
 * Key insight:
 * Depth = 1 (current node) + max(left, right)
 * Each recursive call solves a smaller subproblem.
 */
class MaxDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
