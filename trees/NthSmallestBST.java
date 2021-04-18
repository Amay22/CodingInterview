package trees;


import java.util.Stack;

public class NthSmallestBST {
    private static int NthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;
        int result = 0;

        while(!stack.isEmpty() || p!=null){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode t = stack.pop();
                k--;
                if(k==0)
                    result = t.val;
                p = t.right;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.right = new TreeNode(6);
        System.out.println(NthSmallest(tree, 2));
    }
}
