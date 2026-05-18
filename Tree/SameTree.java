/**
 * LC #100 - Same Tree
 * Link: https://leetcode.com/problems/same-tree/
 * Difficulty: Easy
 * Pattern: Tree recursion
 *
 * Approach:
 * If both null → same → return true
 * If one null → not same → return false
 * If values differ → not same → return false
 * Recurse on both left and right sides
 *
 * Time:  O(n)
 * Space: O(h)
 *
 * Key insight:
 * Check null cases first before comparing values.
 * Both sides must match — use && not ||
 */
class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
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
