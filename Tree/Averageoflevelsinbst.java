/**
 * LC #637 - Average of Levels in Binary Tree
 * Link: https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * Difficulty: Easy
 * Pattern: BFS / Level Order Traversal
 *
 * Approach:
 * Use a Queue for BFS level order traversal
 * For each level → capture size, accumulate sum
 * Add left and right children to queue for next level
 * Divide sum by size → add to result list
 *
 * Time:  O(n) — visit every node once
 * Space: O(w) — w is max width of tree (queue size)
 *
 * Key insight:
 * Capturing queue.size() BEFORE the loop is critical —
 * it freezes the count of nodes at current level only.
 * BFS template: while queue not empty → process level by level.
 * This same BFS pattern applies to many future problems.
 *
 * Solved 100% independently — first BFS problem, nailed it.
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(sum / size);
        }
        return result;
    }
}
