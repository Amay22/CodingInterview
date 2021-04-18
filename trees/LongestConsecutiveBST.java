package trees;

import java.util.LinkedList;

public class LongestConsecutiveBST {
    private static int longestConsecutive(TreeNode root) {
        if(root==null)
            return 0;
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<Integer> sizeQueue = new LinkedList<>();

        nodeQueue.offer(root);
        sizeQueue.offer(1);
        int max=1;

        while(!nodeQueue.isEmpty()){
            TreeNode head = nodeQueue.poll();
            int size = sizeQueue.poll();

            if(head.left!=null){
                int leftSize=size;
                if(head.val==head.left.val-1){
                    leftSize++;
                    max = Math.max(max, leftSize);
                }else{
                    leftSize=1;
                }
                nodeQueue.offer(head.left);
                sizeQueue.offer(leftSize);
            }

            if(head.right!=null){
                int rightSize=size;
                if(head.val==head.right.val-1){
                    rightSize++;
                    max = Math.max(max, rightSize);
                }else{
                    rightSize=1;
                }
                nodeQueue.offer(head.right);
                sizeQueue.offer(rightSize);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(5);
        tree.right.right = new TreeNode(6);
        System.out.println(longestConsecutive(tree));
    }

}
