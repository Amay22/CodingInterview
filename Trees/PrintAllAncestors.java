package Trees;

public class PrintAllAncestors {

    public static boolean printAllAncestors(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root.left == node || root.right == node || printAllAncestors(root.left, node) 
                || printAllAncestors(root.right, node)) {
            System.out.println(root.val);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(6);
        TreeNode tree = new TreeNode(4);
        tree.right = new TreeNode(5);
        tree.right.right = node;
        printAllAncestors(tree, node);
    }
}
