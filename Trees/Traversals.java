package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversals {

    static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> returnList = new ArrayList<>();
        if (root == null) {
            return returnList;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode n = stack.pop();
            returnList.add(n.val);
            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }
        }
        return returnList;
    }

    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> lst = new ArrayList<>();
        if (root == null) {
            return lst;
        }
        Stack<TreeNode> stack = new Stack<>();
        //define a pointer to track nodes
        TreeNode p = root;
        while (!stack.empty() || p != null) {
            // if it is not null, push to stack
            //and go down the tree to left
            if (p != null) {
                stack.push(p);
                p = p.left;
                // if no left child
                // pop stack, process the node
                // then let p point to the right
            } else {
                TreeNode t = stack.pop();
                lst.add(t.val);
                p = t.right;
            }
        }
        return lst;
    }

    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> lst = new ArrayList<>();
        if (root == null) {
            return lst;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.empty()) {
            TreeNode curr = stack.peek();
// go down the tree.
//check if current node is leaf, if so, process it and pop stack,
//otherwise, keep going down
            if (prev == null || prev.left == curr || prev.right == curr) {
//prev == null is the situation for the root node
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    stack.pop();
                    lst.add(curr.val);
                }
//go up the tree from left node
//need to check if there is a right child
//if yes, push it to stack
//otherwise, process parent and pop stack
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    stack.pop();
                    lst.add(curr.val);
                }
                //go up the tree from right node
                //after coming back from right node, process parent node and pop

            } else if (curr.right == prev) {
                stack.pop();
                lst.add(curr.val);
            }
            prev = curr;
        }
        return lst;
    }

    static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();        
        if (root == null) { return al; }
        ArrayList<Integer> nodeValues = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        current.add(root);
        while (!current.isEmpty()) {
            TreeNode node = current.remove();
            if (node.left != null) { next.add(node.left); }
            if (node.right != null) { next.add(node.right); }
            nodeValues.add(node.val);
            if (current.isEmpty()) {
                current = next;
                next = new LinkedList<>();
                al.add(nodeValues);
                nodeValues = new ArrayList<>();
            }
        }
        return al;
    }

    public static int size(TreeNode root) {
        int leftCount = root.left == null ? 0 : size(root.left);
        int rightCount = root.right == null ? 0 : size(root.right);
        return 1 + leftCount + rightCount;
    }

    public static int sizeLeveLOrder(TreeNode root) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            count++;
            if (tmp.left != null) {
                q.offer(tmp.right);
            }
            if (tmp.right != null) {
                q.offer(tmp.right);
            }
        }
        return count;
    }

    public static void main(String args[]) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.right.left = new TreeNode(5);
        System.out.println("Inorder");
        inorderTraversal(tree).forEach(System.out::print);
        System.out.println("\nPostOrder");
        postorderTraversal(tree).forEach(System.out::print);
        System.out.println("\nPreOrder");
        preorderTraversal(tree).forEach(System.out::print);
        System.out.println("\nLevel Order");
        levelOrder(tree).forEach((t) -> {
            t.forEach(System.out::print);
            System.out.println("");
        });
        System.out.println("\nSize = "+ size(tree));
        
        System.out.println("");
    }
}
