/**
 * LC #572 - Subtree of Another Tree
 * Link: https://leetcode.com/problems/subtree-of-another-tree/
 * Difficulty: Easy
 * Pattern: Tree recursion + helper function
 *
 * Approach:
 * At every node in root — check if it matches subRoot
 * Use isSameTree helper to check match
 * If not match — check left and right subtrees
 *
 * Time:  O(m×n) — m nodes in root, n nodes in subRoot
 * Space: O(h)
 *
 * Key insight:
 * Reuse isSameTree as helper.
 * Two separate functions — one traverses, one compares.
 * Helper defined OUTSIDE main function, inside class.
 *
 * Common mistake fixed:
 * Never define function inside another function in Java.
 * Always: main function closes → then helper defined.
 */
class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}
