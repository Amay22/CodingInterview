package Trees;

public class CheckMirrors {

    public static boolean areMirrors(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val ) {
            return false;
        } else {
            return (areMirrors(root1.left, root2.right) && areMirrors(root1.right, root2.left));
        }
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(2);
        tree1.left = new TreeNode(1);
        tree1.right = new TreeNode(3);
        TreeNode tree2 = new TreeNode(2);
        tree2.left = new TreeNode(3);
        tree2.right = new TreeNode(1);
        System.out.println(areMirrors(tree1, tree2));
        tree2.right = new TreeNode(2);
        System.out.println(areMirrors(tree1, tree2));

    }

}
