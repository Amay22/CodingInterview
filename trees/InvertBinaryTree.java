package trees;

// invert a binary tree

public class InvertBinaryTree {

    private static void recursiveInvertTree(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left!=null)
            recursiveInvertTree(root.left);

        if(root.right!=null)
            recursiveInvertTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.right = new TreeNode(6);
        System.out.println("Original Tree:");
        Traversals.levelOrder(tree).forEach(System.out::println);
        recursiveInvertTree(tree);
        System.out.println("Gets Inverted to:");
        Traversals.levelOrder(tree).forEach(System.out::println);
    }
}
