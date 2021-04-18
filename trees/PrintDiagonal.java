
package trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PrintDiagonal {

    public static void printDiagonal(TreeNode root){
        Queue<TreeNode> diag = new LinkedList<>();
        diag.offer(root);
        TreeNode temp = null;
        Set<TreeNode> lefties = new HashSet<>();
        while((root= root.left) !=null){
            lefties.add(root);
        }
        while((root=diag.poll()) != null){
            if(lefties.contains(root)){
                System.out.println("");
            }
            System.out.print(root.val+" ,");
            while(root!=null){
                if(root.left != null){

                    diag.offer(root.left);
                }
                if(root.right!=null){
                    System.out.print(root.right.val+" ,");
                }
                root = root.right;
            }

        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(2);
        tree.right.right = new TreeNode(3);
        tree.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right.left = new TreeNode(7);
        tree.left.left = new TreeNode(8);
        tree.left.left.right = new TreeNode(9);
        tree.right.right.left.left = new TreeNode(10);
              printDiagonal(tree);
    }
}
