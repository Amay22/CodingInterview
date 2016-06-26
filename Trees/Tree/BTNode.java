package Trees.Tree;

interface BTNodeADT<T> {

    public T getData();

    public BTNode<T> getRight();

    public BTNode<T> getLeft();

    public void setData(T data);

    public void setRight(BTNode<T> right);

    public void setLeft(BTNode<T> left);

}

public class BTNode<T> implements BTNodeADT<T> {

    private T data;

    private BTNode<T> right;

    private BTNode<T> left;

    public BTNode() {
        left = null;
        right = null;
        data = null;
    }

    public BTNode(T set_data) {
        left = null;
        right = null;
        data = set_data;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public BTNode<T> getRight() {
        return right;
    }

    @Override
    public BTNode<T> getLeft() {
        return left;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public void setRight(BTNode<T> right) {
        this.right = right;
    }

    @Override
    public void setLeft(BTNode<T> left) {
        this.left = left;
    }
}
