package trees;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }

    public List<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> l = new ArrayList<>();
        l.add(root.val);
        dfs(root, sum - root.val, result, l);
        return result;
    }

    public void dfs(TreeNode t, int sum, ArrayList<ArrayList<Integer>> result,
            ArrayList<Integer> l) {
        if (t.left == null && t.right == null && sum == 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(l);
            result.add(temp);
        }
//search path of left node
        if (t.left != null) {
            l.add(t.left.val);
            dfs(t.left, sum - t.left.val, result, l);
            l.remove(l.size() - 1);
        }
//search path of right node
        if (t.right != null) {
            l.add(t.right.val);
            dfs(t.right, sum - t.right.val, result, l);
            l.remove(l.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(3);
        System.out.println(hasPathSum(tree, 3));
        System.out.println(hasPathSum(tree, 4));

    }
}
