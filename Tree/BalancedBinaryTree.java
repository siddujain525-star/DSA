/**
 * LC #110 - Balanced Binary Tree
 * Link: https://leetcode.com/problems/balanced-binary-tree/
 * Difficulty: Easy
 * Pattern: Tree recursion + sentinel value
 *
 * Approach:
 * Use -1 as signal for "unbalanced found"
 * At every node check abs(leftH - rightH) <= 1
 * If unbalanced anywhere → propagate -1 upward
 * Main function: if dfsHeight(root) != -1 → balanced
 *
 * Time:  O(n)
 * Space: O(h)
 *
 * Key insight:
 * Return -1 as sentinel value meaning "unbalanced"
 * Once -1 found → all parent calls return -1 too
 * Avoids checking entire tree again from top
 *
 * Common mistakes fixed:
 * = assigns, == compares — always use == in if statements
 * Math.abs not Math.ads
 * Helper returns int not boolean
 * return -1 not return false in int function
 */
class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = dfsHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = dfsHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
