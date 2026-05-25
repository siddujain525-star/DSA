/**
 * LC #617 - Merge Two Binary Trees
 * Link: https://leetcode.com/problems/merge-two-binary-trees/
 * Difficulty: Easy
 * Pattern: Recursion / DFS
 *
 * Approach:
 * If root1 is null → return root2
 * If root2 is null → return root1
 * Add root2.val into root1.val
 * Recurse left and right subtrees
 * Return root1 as the merged tree
 *
 * Time:  O(n) — n is min nodes of both trees
 * Space: O(h) — h is height of smaller tree
 *
 * Key insight:
 * Modify root1 in place — no need for a new node.
 * Base cases handle the "only one tree exists" scenario.
 * Same DFS skeleton as every other tree problem.
 *
 * Solved 100% independently — clean and optimal solution.
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        
        root1.val += root2.val;
        
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        
        return root1;
        
    }
}
