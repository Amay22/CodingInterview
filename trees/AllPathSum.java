package trees;

import java.util.ArrayList;

public class AllPathSum {

    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> l = new ArrayList<>();
        l.add(root.val);
        dfs(root, sum - root.val, result, l);
        return result;
    }

    public static void dfs(TreeNode t, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> l) {
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
        tree.right = new TreeNode(1);
        ArrayList<ArrayList<Integer>> result = pathSum(tree, 3);
        result.forEach((ans)->{ans.forEach((i)->{
            System.out.print(i+", ");
        });System.out.println("");
        });
    }
}
