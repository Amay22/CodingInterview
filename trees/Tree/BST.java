package trees.Tree;

public class BST<T extends Comparable<T>> {

    private BTNode root;

    public void setRoot(BTNode root) {
        this.root = root;
    }

    public BST() {
        root = null;
    }

    public BTNode getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }


    public BTNode<T> insert(T data) {
        if (root == null) {
            root = new BTNode(data);
        }
        BTNode<T> current = root;
        while(current != null){
            if(current.getData().compareTo(data) < 0){
                if(current.getRight() != null){
                    current = current.getRight();
                }else{
                    current.setRight(new BTNode<>(data));
                }
            }else if(current.getData().compareTo(data) > 0){
                if(current.getLeft()!= null){
                    current = current.getLeft();
                }else{
                    current.setLeft(new BTNode<>(data));
                }
            }else{
                    current = null;
                    break;
            }
        }
        return current;
    }

//    public BTNode<T> search(T val) {
//
//    }

    public void preorder() {
        preorder(root);
    }

    public void preorder(BTNode<T> r) {
        if (r != null) {
            System.out.print(r.getData() + " ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }

    public void inorder() {
        inorder(root);
    }

    public void inorder(BTNode<T> r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.print(r.getData() + " ");
            inorder(r.getRight());
        }
    }

    public void postorder() {
        postorder(root);
    }

    public void postorder(BTNode<T> r) {
        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() + " ");
        }
    }
}
