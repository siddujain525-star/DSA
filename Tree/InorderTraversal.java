/**
 * LC #94 - Binary Tree Inorder Traversal
 * Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Difficulty: Easy
 * Pattern: Tree recursion + helper function
 *
 * Approach:
 * Use helper function for recursion.
 * Inorder: left → root → right
 * Add node.val to result list at each node.
 *
 * Time:  O(n) — visits every node once
 * Space: O(n) — result list + recursion stack
 *
 * Key insight:
 * When recursion + return a list — use two functions:
 * 1. Main function — creates list, calls helper, returns list
 * 2. Helper function — does the recursion
 *
 * Traversal orders:
 * Preorder:  root → left → right
 * Inorder:   left → root → right ← this problem
 * Postorder: left → right → root
 *
 * Common mistakes fixed:
 * node.data → node.val (LeetCode uses .val)
 * Code after return never executes
 * Helper must be defined outside main function
 */
class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        tra(root, result);
        return result;
    }

    void tra(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        tra(node.left, result);
        result.add(node.val);
        tra(node.right, result);
    }
}
