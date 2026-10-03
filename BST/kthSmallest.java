import java.util.ArrayList;
import java.util.List;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        tra(root, result);
        return result.get(k - 1); 
    }

    public void tra(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        tra(node.left, result);
        result.add(node.val);
        tra(node.right, result);
    }
}
