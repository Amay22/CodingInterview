package trees;

public class LCABinary {

    public static TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || root == a || root == b) {
            return root;
        }
        TreeNode left = LCA(root.left, a, b);
        TreeNode right = LCA(root.right, a, b);
        if (left != null && right != null) {
            return root;// nodes are each on a separate branch
        } else {
            return (left != null ? left : right);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(6);
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(3);
        tree.left.left = node1;
        tree.left.right = node2;
        tree.right.right = node3;
        System.out.println(LCA(tree, node1, node2).val);
        System.out.println(LCA(tree, node1, node3).val);
    }
}
