/**
 * LC #938 - Range Sum of BST
 * Link: https://leetcode.com/problems/range-sum-of-bst/
 * Difficulty: Easy
 * Pattern: BST / DFS
 *
 * Approach:
 * If root is null → return 0
 * If val < low → only go right (left side too small)
 * If val > high → only go left (right side too big)
 * Else → add current val + recurse both sides
 *
 * Time:  O(n) worst case, better in practice due to pruning
 * Space: O(h)
 *
 * Key insight:
 * BST property allows smart pruning of branches.
 * No need to explore subtrees that are out of range.
 * Cleaner and faster than checking every node.
 *
 * Solved 100% independently — optimal BST pruning applied correctly.
 */

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
