/*
The diameter of a tree (sometimes called the width) is the number of nodes
on the longest path between two leaves in the tree. 
As you can see diameter is not returned. instead the max left or right is returned
This has been done so that height can be calculated using recursion while diameter stores the dia.
*/
package Trees;

public class DiameterTree {

    public static int diameter = 0;

    public static int diameterOfTree(TreeNode root) {
        int left, right;
        if (root == null) {
            return 0;
        }
        left = diameterOfTree(root.left);
        right = diameterOfTree(root.right);
        diameter = (left + right > diameter) ? left + right + 1: diameter;
        return Math.max(left, right) + 1;
    }   
    
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(5);
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(3);
        tree.right.right =  new TreeNode(6);        
        System.out.println(diameterOfTree(tree));
        System.out.println(diameter);
    }
}