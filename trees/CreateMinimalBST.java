package trees;

class CreateMinimalBST {

    static TreeNode createBST(int arr[], int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createBST(arr, start, mid - 1);
        n.right = createBST(arr, mid + 1, end);
        return n;
    }
}
