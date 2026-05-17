/**
 * LC #543 - Diameter of Binary Tree
 * Link: https://leetcode.com/problems/diameter-of-binary-tree/
 * Difficulty: Easy
 * Pattern: Tree recursion + global variable trick
 *
 * Approach:
 * Diameter at each node = leftHeight + rightHeight
 * Track maximum diameter using int[] array (pass by reference)
 * Return height from each node for parent to use
 *
 * Time:  O(n)
 * Space: O(h)
 *
 * Key insight:
 * Can't return two values from one function.
 * Use int[] to track global max across recursive calls.
 * int is pass by value — int[] is pass by reference.
 *
 * int[] trick:
 * int max = 0 → changes inside function don't affect outside
 * int[] max = new int[1] → changes DO affect outside
 */
class DiameterBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    private int height(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
}
