/*
Serialize binary tree. Or flatten it.
Just add the left subtree to the right and and we need to store the right subtree in a temporary stack.
Every iteration move down right.
Once left sub tree comes to the right. start popping the stack and adding left first then right.
*/
package trees;

import java.util.Stack;

public class FlattenBT {

    public static TreeNode flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.empty()) {
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                p.right = p.left;
                p.left = null;
            } else if (!stack.empty()) {
                p.right = stack.pop();
            }
            p = p.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(5);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right.right = new TreeNode(6);
        tree = flatten(tree);
        while (tree != null) {
            System.out.print(tree.val + " ,");
            tree = tree.right;
        }
    }
}
