/**
 * LC #244 - Preorder Traversal
 * Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
 * Difficulty: Easy
 * Pattern: Tree Traversal
 *
 * Approach:
 * Preorder Traversal
 * Time:  O(n) — visits every node once
 * Space: O(h) — h is height of tree, recursion stack
 *
 * Key insight:
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
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>result = new ArrayList<>();
        tra(root , result);
        return result;
    }
    public void tra(TreeNode node,List<Integer>result){
        if( node == null){
            return ;
        }
        result.add(node.val);
        tra(node.left,result);
        tra(node.right,result);
    }       
}
