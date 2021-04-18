package trees;

public class ValidateAVL {

    public static boolean isAVL(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        return root.val > min && root.val < max && isAVL(root.left, min, root.val) && isAVL(root.right, root.val, max) && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }

    public static int getHeight(TreeNode root) {
        int leftHeight, rightHeight;
        if (root == null) {
            return 0;
        } else {
            leftHeight = getHeight(root.left);
            rightHeight = getHeight(root.right);
            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(1);
        tree.right.right = new TreeNode(5);
        System.out.println("Is AVL : " + isAVL(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
