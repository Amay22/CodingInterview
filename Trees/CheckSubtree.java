
package Trees;

public class CheckSubtree {
     static boolean areIdentical(TreeNode node1, TreeNode node2) {
 
        /* base cases */
        if (node1 == null && node2 == null) {
            return true;
        }
 
        if (node1 == null || node2 == null) {
            return false;
        }
 
        /* Check if the data of both roots is same and data of left and right
         subtrees are also same */
        return (node1.val == node2.val
                && areIdentical(node1.left, node2.left)
                && areIdentical(node1.right, node2.right));
    }
 
    /* This function returns true if S is a subtree of T, otherwise false */
    static boolean isSubtree(TreeNode T, TreeNode S) {
 
        /* base cases */
        if (S == null) {
            return true;
        }
 
        if (T == null) {
            return false;
        }
 
        /* Check the tree with root as current node */
        if (areIdentical(T, S)) {
            return true;
        }
 
        /* If the tree with root as current node doesn't match then
         try left and right subtrees one by one */
        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }
    
    public static void main(String args[]) {
        TreeNode tree = new TreeNode(26);
         
        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */
        tree.left = new TreeNode(10);
        tree.left.left = new TreeNode(4);
        tree.left.left.right = new TreeNode(30);
        tree.left.right = new TreeNode(6);
        tree.right = new TreeNode(3);
        tree.right.right = new TreeNode(3);
 
        
         TreeNode subtree = new TreeNode(10);
        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */
         
        subtree.right = new TreeNode(6);
        subtree.left = new TreeNode(4);
        subtree.left.right = new TreeNode(30);
        
        System.out.println(isSubtree(tree, subtree));
        
        subtree.left.right = null;
        System.out.println(isSubtree(tree, subtree));
        
        
    }
}
