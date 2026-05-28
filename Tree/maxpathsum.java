/**
 * LC #124 - Binary Tree Maximum Path Sum
 * Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * Difficulty: Hard
 * Pattern: DFS / Post-order Traversal
 *
 * Approach:
 * Use post-order DFS to evaluate each node bottom-up
 * At every node, compute the best "bent" path through it (left + node + right)
 * Update global max if this bent path is the best seen so far
 * Return only ONE arm (max of left/right + node) to the parent
 * because a path cannot fork — it must stay a straight sequence
 *
 * Time:  O(n) — visit every node exactly once
 * Space: O(h) — h is height of tree (recursion call stack)
 *
 * Key insights:
 * Math.max(0, ...) discards negative subtrees — they only hurt the sum
 * int[] array used to simulate pass-by-reference for the global max
 * Two jobs per node: record best bent path, return best single arm upward
 * This DFS template is reusable: LC #543 (Diameter), LC #687 (Longest Univalue Path)
 *
 * Solved 100% independently — clean and optimal solution.
 */

class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }

    private int maxPathDown(TreeNode node, int[] maxValue) {
        if (node == null) return 0;

        int left  = Math.max(0, maxPathDown(node.left,  maxValue));
        int right = Math.max(0, maxPathDown(node.right, maxValue));

        maxValue[0] = Math.max(maxValue[0], left + right + node.val);

        return Math.max(left, right) + node.val;
    }
}
