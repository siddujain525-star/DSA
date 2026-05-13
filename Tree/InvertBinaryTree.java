/**
 * LC #226 - Invert Binary Tree
 * Link: https://leetcode.com/problems/invert-binary-tree/
 * Difficulty: Easy
 * Pattern: Tree recursion
 *
 * Approach:
 * At every node — swap left and right children.
 * Recurse on left and right subtrees.
 * Base case: if root is null → return null.
 *
 * Time:  O(n) — visits every node once
 * Space: O(h) — h is height of tree, recursion stack
 *
 * Key insight:
 * Recursion IS the traversal.
 * We just define the ACTION at each node — swap.
 * No separate traversal function needed.
 *
 * Tree problem skeleton — use for every tree problem:
 * 1. Base case — if null return
 * 2. Do something at current node
 * 3. Recurse left and right
 * 4. Return root
 *
 * Concepts learned today:
 * - Preorder traversal visits + prints each node
 * - Invert tree visits + swaps each node
 * - Same skeleton, different action
 * - Recursion = function calling itself
 */
class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // recurse — traversal is automatic
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
