package trees;

public class WidthTree {

    public static int width(TreeNode root) {
        int max = 0;
        int height = maxDepthRecursive(root);
        for (int k = 0; k <= height; k++) {
            int tmp = width(root, k);
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }

    public static int maxDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /* compute the depth of each subtree */
        int leftDepth = maxDepthRecursive(root.left);
        int rightDepth = maxDepthRecursive(root.right);
        return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
    }
    // Returns the number of node on a given level

    public static int width(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        } else if (depth == 0) {
            return 1;
        } else {
            return width(root.left, depth - 1) + width(root.right, depth - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(5);
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(3);
        tree.right.right = new TreeNode(6);

        System.out.println("Width of tree :"+width(tree));
        System.out.println("Width of tree on level 1 :"+width(tree,1));
    }
}
