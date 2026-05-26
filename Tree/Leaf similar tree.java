/**
 * LC #872 - Leaf-Similar Trees
 * Link: https://leetcode.com/problems/leaf-similar-trees/
 * Difficulty: Easy
 * Pattern: DFS / Leaf Collection
 *
 * Approach:
 * Collect leaf values from both trees into separate lists
 * Helper getLeaves() traverses left then right
 * If node is a leaf → add to list
 * Compare both lists using equals()
 *
 * Time:  O(n + m) — n and m are sizes of both trees
 * Space: O(n + m) — storing all leaves of both trees
 *
 * Key insight:
 * Leaf sequence must be collected left → right (DFS order).
 * List.equals() handles full sequence comparison cleanly.
 * Helper function keeps main function clean and readable.
 *
 * Solved 100% independently — clean and optimal solution.
 */
 class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        
        
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        
        
        return leaves1.equals(leaves2);
    }
    
    private void getLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) return;
        
    
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }
        
    
        getLeaves(node.left, leaves);
        getLeaves(node.right, leaves);
    }
    }
