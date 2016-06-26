package Trees;

public class ValidateBST {
  
    public static boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        return (root.val > min && root.val < max && isBST(root.left, min, root.val) && isBST(root.right, root.val, max));
    }
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(3);        
        System.out.println(isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));
        tree.left = new TreeNode(4);
        System.out.println(isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
