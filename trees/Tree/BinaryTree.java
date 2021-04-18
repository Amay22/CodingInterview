package trees.Tree;

public class BinaryTree<T> {

    private BTNode root;

    public void setRoot(BTNode root) {
        this.root = root;
    }

    public BinaryTree() {
        root = null;
    }

    public BTNode getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public BTNode<T> insert(T data) {
        return insert(root, data);
    }

    public BTNode<T> insert(BTNode<T> node, T data) {
        if (node == null) {
            node = new BTNode(data);
        } else {
            if (node.getRight() == null) {
                node.setRight(insert(node.getRight(), data));
            } else {
                node.setLeft(insert(node.getLeft(), data));
            }
        }
        return node;
    }

    public void insert(BTNode<T> root, BTNode<T> node) {
        if (root.getRight() == null) {
            root.setRight(node);
        } else if(root.getLeft() == null)   {
            root.setLeft(node);
        }else{
            insert(root.getLeft(), node);
            insert(root.getRight(), node);
        }
    }

    public int countNodes() {
        return countNodes(root);
    }

    public int countNodes(BTNode<T> r) {
        if (r == null) {
            return 0;
        } else {
            int count = 1;
            count += countNodes(r.getLeft());
            count += countNodes(r.getRight());
            return count;
        }
    }

    public BTNode<T> search(T val) {
        return search(root, val);
    }

    public BTNode<T> search(BTNode<T> r, T val) {
        if (r.getData() == val) {
            return r;
        }
        if (r.getLeft() != null) {
            return search(r.getLeft(), val);
        }
        if (r.getRight() != null) {
            return search(r.getRight(), val);
        }
        return null;
    }

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

    public BTNode<T> getParent(BTNode<T> root, BTNode<T> node) {
        if (root.getLeft().getData() == node.getData() || node.getData() == root.getRight().getData()) {
            return root;
        }
        if (root.getLeft() != null) {
            return getParent(root.getLeft(), node);
        }
        if (root.getRight() != null) {
            return getParent(root.getRight(), node);
        }
        return null;
    }

    public BTNode<T> getParent(BTNode<T> root, T val) {
        if (root.getLeft().getData() == val || val == root.getRight().getData()) {
            return root;
        }
        if (root.getLeft() != null) {
            return getParent(root.getLeft(), val);
        }
        if (root.getRight() != null) {
            return getParent(root.getRight(), val);
        }
        return null;
    }

    public void deleteNode(BTNode<T> root, T val) {
        BTNode<T> parent = getParent(root, val);
        if (parent != null) {
            BTNode<T> to_delete = parent.getLeft().getData() == val ? parent.getLeft() : parent.getRight();
            BTNode<T> left = to_delete.getLeft();
            BTNode<T> right = to_delete.getRight();
            if (left == null && right == null) {
                parent.setLeft(null);
            } else if (left == null && right != null) {
                parent.setLeft(right);
            } else if (left != null && right == null) {
                parent.setLeft(left);
            } else {
                if(parent.getLeft().getData() == val){parent.setLeft(left);}else{parent.setRight(left);}
                insert(parent, right);
            }
        }
    }
}
