/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        TreeNode left = root;
        TreeNode right = root;

        while (true) {

            // Inorder: smallest values first
            while (left != null) {
                s1.push(left);
                left = left.left;
            }

            // Reverse inorder: largest values first
            while (right != null) {
                s2.push(right);
                right = right.right;
            }

            if (s1.isEmpty() || s2.isEmpty()) {
                return false;
            }

            TreeNode l = s1.peek();
            TreeNode r = s2.peek();

            // Stop when both pointers meet or cross
            if (l.val >= r.val) {
                return false;
            }

            int sum = l.val + r.val;

            if (sum == k) {
                return true;
            } else if (sum < k) {
                s1.pop();
                left = l.right;
            } else {
                s2.pop();
                right = r.left;
            }
        }
    }
}
