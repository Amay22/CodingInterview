package trees;

public class LCABST {

    public static TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || root == a || root == b ) {
            return root;
        }
        if (Math.max(a.val, b.val) < root.val){
            return LCA(root.left, a, b);
        } else if (Math.min(a.val, b.val) > root.val){
            return LCA(root.right, a, b);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(5);
        tree.left.left = node1;
        tree.left.right = node2;
        tree.right.right = node3;
        System.out.println(LCA(tree, node1, node2).val);
        System.out.println(LCA(tree, node1, node3).val);
    }
}
