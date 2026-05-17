/**
 * LC #111 - Minimum Depth of Binary Tree
 * Link: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Difficulty: Easy
 * Pattern: Tree recursion
 *
 * Approach:
 * If root is null → return 0
 * If left child null → only go right
 * If right child null → only go left
 * If both exist → take minimum of both
 *
 * Time:  O(n)
 * Space: O(h) — h is height of tree
 *
 * Key insight:
 * Min depth = depth to nearest LEAF node.
 * Leaf = node with NO children (both null).
 * If one child is null → it's not a leaf path.
 * Must ignore null child side — don't take min with 0.
 *
 * Classic trap:
 * Math.min(leftDepth, rightDepth) + 1 fails
 * when one child is null — picks 0 as minimum
 * which represents non-existent path not a leaf.
 *
 * Difference from Max Depth:
 * Max depth: null = 0, always take max → works fine
 * Min depth: null child = ignore that side completely
 */
class MinDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
