package Trees;

public class TreeHeight {

    public static int checkHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE; // Propagate error up
        }
        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE; // Propagate error up
        }
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE; // Found error -> pass it back
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public static void main(String[] args) {        
        int[] array = {0, 1, 2, 3,5, 6, 7, 8, 9, 10};
        TreeNode root = CreateMinimalBST.createBST(array, 0, array.length-1);
        
        System.out.println(checkHeight(root));

        System.out.println("Is balanced? " + isBalanced(root));

    }
}
