package Trees;

public class PrintAllPaths {

    public static void printPaths(TreeNode root) {
        int[] path = new int[256];
        printPaths(root, path, 0);
    }

    private static void printPaths(TreeNode root, int[] path, int pathLen) {
        if (root == null) {
            return;
        }        
        path[pathLen++] = root.val;        
        if (root.left == null && root.right == null) {
            printArray(path, pathLen);
        } else {	
            printPaths(root.left, path, pathLen);
            printPaths(root.right, path, pathLen);
        }
    }

    private static void printArray(int[] ints, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(5);
        tree.left.left = node1;
        tree.left.right = node2;
        tree.right.right = node3;
        printPaths(tree);
    }
}
