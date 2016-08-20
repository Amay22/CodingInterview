package Trees;

public class InOrderSuccessorBST {
    private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null)
            return null;

        TreeNode next = null;
        TreeNode c = root;
        while(c!=null && c.val!=p.val){
            if(c.val > p.val){
                next = c;
                c = c.left;
            }else{
                c= c.right;
            }
        }

        if(c==null)
            return null;

        if(c.right==null)
            return next;

        c = c.right;
        while(c.left!=null)
            c = c.left;

        return c;
    }
    public static void main(String[] args) {
        TreeNode nth = new TreeNode(5);
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(2);
        tree.right = nth;
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(3);
        tree.right.right = new TreeNode(6);
        System.out.println(inorderSuccessor(tree, nth).val);

    }
}
