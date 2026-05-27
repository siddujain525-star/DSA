/**
 * LC #102 - Binary Tree Level Order Traversal
 * Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Difficulty: Medium
 * Pattern: BFS / Level Order Traversal
 *
 * Approach:
 * Use a Queue for BFS level order traversal
 * Capture levelSize before loop to freeze current level count
 * For each level → create new list, collect all node values
 * Add children to queue for next level
 * Add current level list to result
 *
 * Time:  O(n) — visit every node once
 * Space: O(w) — w is max width of tree (queue size)
 *
 * Key insight:
 * Same BFS template as Average of Levels (LC #637)
 * Difference — collect values into a list instead of averaging.
 * Capturing queue.size() BEFORE loop is critical every time.
 * This BFS template is reusable for many future problems.
 *
 * Solved 100% independently — clean and optimal solution.
 */
class Solution{     public List<List<Integer>> levelOrder(TreeNode root) {         List<List<Integer>> result = new ArrayList<>();         if (root == null) {             return result;         }
        Queue<TreeNode> queue = new LinkedList<>();         queue.add(root);
        while (!queue.isEmpty()) {             int levelSize = queue.size();             List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {                 TreeNode currentNode = queue.poll();                 currentLevel.add(currentNode.val);
                if (currentNode.left != null) {                     queue.add(currentNode.left);                 }                 if (currentNode.right != null) {                     queue.add(currentNode.right);                 }             }             result.add(currentLevel);         }
        return result;     } }
