/**
 * LC #101 - Symmetric Tree
 * Link: https://leetcode.com/problems/symmetric-tree/
 * Difficulty: Easy
 * Pattern: Tree recursion / Mirror comparison
 *
 * Approach:
 * If root is null → return true
 * Use helper isMirror(t1, t2) to compare two nodes
 * If both null → true (base case)
 * If one null → false (asymmetric)
 * Recursively cross-compare: t1.left with t2.right, t1.right with t2.left
 *
 * Time:  O(n)
 * Space: O(h) — h is height of tree (recursion stack)
 *
 * Key insight:
 * Mirror symmetry means cross-comparison, not same-side comparison.
 * t1.left must match t2.right and t1.right must match t2.left.
 * Classic two-pointer recursion on a single tree.
 *
 * Solved with minor bug fixes (null check + wrong recursive calls corrected).
 */
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }
}
