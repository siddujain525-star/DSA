/**
 * LC #700 - Search in a BST
 * Link: https://leetcode.com/problems/search-in-a-binary-search-tree/
 * Difficulty: Easy
 * Pattern: BST / Recursion
 *
 * Approach:
 * If root is null → return null (not found)
 * If root.val == val → return root (found!)
 * If val < root.val → search left subtree
 * If val > root.val → search right subtree
 *
 * Time:  O(h) — h is height of BST
 * Space: O(h) — recursion stack
 *
 * Key insight:
 * BST property eliminates half the tree at each step.
 * Base case handles both null and found in one clean line.
 * Returns entire subtree rooted at found node, not just boolean.
 *
 * Solved 100% independently — clean and optimal BST search.
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
