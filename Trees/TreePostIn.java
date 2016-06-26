package Trees;

import static Trees.Traversals.inorderTraversal;

public class TreePostIn {

    public static TreeNode buildBT(int[] postOrder, int postStart, int postEnd, int[] inOrder, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        int val = postOrder[postEnd];
        int offset = inStart;
        TreeNode cur = new TreeNode(val);
        // search for the inorder index
        for (; offset < inEnd; offset++) {
            if (inOrder[offset] == val) {
                break;
            }
        }
        cur.left = buildBT(postOrder, postStart, postStart + offset - inStart - 1, inOrder, inStart, offset - 1);
        cur.right = buildBT(postOrder, postStart + offset - inStart, postEnd - 1, inOrder, offset + 1, inEnd);
        return cur;
    }

    public static void main(String args[]) {
        int in[] = new int[]{4, 2, 5, 1, 6, 3};
        int post[] = new int[]{1, 2, 4, 5, 3, 6};
        TreeNode mynode = buildBT(post, 0, post.length-1, in, 0, in.length - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        inorderTraversal(mynode).forEach(System.out::print);
        System.out.println("");
    }
}
