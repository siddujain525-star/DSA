/**
 * LC #222 - Count Complete Tree Nodes
 * Link: https://leetcode.com/problems/count-complete-tree-nodes/
 * Difficulty: Easy
 * Pattern: Tree recursion
 *
 * Approach:
 * If root is null → return 0
 * Count left subtree recursively
 * Count right subtree recursively
 * Return 1 + left + right
 *
 * Time:  O(n)
 * Space: O(h)
 *
 * Key insight:
 * Simplest tree problem — just count every node.
 * Same skeleton as every other tree problem.
 * No helper function needed — single function suffices.
 *
 * Solved 100% independently — no AI help.
 */
class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return 1 + (left + right);
    }
}
