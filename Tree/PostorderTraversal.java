/**
 * LC #145 - Binary Tree Postorder Traversal
 * Link: https://leetcode.com/problems/binary-tree-postorder-traversal/
 * Difficulty: Easy
 * Pattern: Tree recursion + helper function
 *
 * Approach:
 * Use helper function for recursion.
 * Postorder: left → right → root
 * Add node.val AFTER recursing on both sides.
 *
 * Time:  O(n) — visits every node once
 * Space: O(n) — result list + recursion stack
 *
 * Key insight:
 * Postorder processes children BEFORE parent.
 * Used for: deleting tree, evaluating expressions.
 *
 * All three traversals compared:
 * Preorder:  add BEFORE recursing  (root first)
 * Inorder:   add BETWEEN recursing (root middle)
 * Postorder: add AFTER recursing   (root last)
 *
 * Common mistakes fixed today:
 * void function → return; not return null;
 * parameter name is node (lowercase)
 * Node (uppercase) is the class — not your parameter
 */
class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        tra(root, result);
        return result;
    }

    public void tra(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        tra(node.left, result);
        tra(node.right, result);
        result.add(node.val);
    }
}
