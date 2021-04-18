package linkedlists;


interface Node<T> {

    public void setNext(ListNode<T> next);

    public void setData(T data);

    public ListNode<T> getNext();

    public T getData();

}

class ListNode<T> implements Node<T> {

    ListNode<T> next;
    T data;
    boolean val;

    ListNode(T newData) {
        next = null;
        data = newData;
    }

    ListNode(T new_data, ListNode<T> new_next) {
        next = new_next;
        data = new_data;
    }

    @Override
    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public ListNode<T> getNext() {
        return next;
    }

    @Override
    public T getData() {
        return data;
    }
}

class LinkedList<T>{
    ListNode<T> head;


    ListNode<T> tail;

    public LinkedList(){
        head = null;
        tail = null;
    }

    public ListNode<T> getHead() {
        return head;
    }

    public void insert(ListNode<T> node){
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.setNext(node);
            tail = tail.getNext();
        }
    }
}

public class ReverseLinkedList {

    ///////////////////////////////////////////////////////////
    /////////////////////RECURSIVE  ANSWER////////////////////
    //////////////////////////////////////////////////////////
    public static ListNode recursive_reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode second = head.next;
        head.next = null;
        ListNode rest = recursive_reverseList(second);
        second.next = head;
        return rest;
    }

    ///////////////////////////////////////////////////////////
    /////////////////////ITERATIVE  ANSWER////////////////////
    //////////////////////////////////////////////////////////
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node1 = head;
        ListNode node2 = head.next;
        head.next = null;
        while (node1 != null && node2 != null) {
            ListNode tmp = node2.next;
            node2.next = node1;
            node1 = node2;
            if (tmp != null) {
                node2 = tmp;
            }else{
                break;
            }
        }
        return node2;
    }



    public static void main(String[] args) {
        System.out.println("Recursive");
        LinkedList<Integer> ll = new LinkedList<>();
        ll.insert(new ListNode<>(0));
        ll.insert(new ListNode<>(1));
        ll.insert(new ListNode<>(2));
        ll.insert(new ListNode<>(3));
        ListNode result = recursive_reverseList(ll.getHead());
        while (result != null) {
            System.out.print(result.data + ",");
            result = result.next;
        }
        System.out.println("\nNon-Recursive");
        LinkedList<Integer> ll1 = new LinkedList<>();
        ll1.insert(new ListNode<>(0));
        ll1.insert(new ListNode<>(1));
        ll1.insert(new ListNode<>(2));
        ll1.insert(new ListNode<>(3));
        result = reverseList(ll1.getHead());
        while (result != null) {
            System.out.print(result.data + ",");
            result = result.next;
        }
        System.out.println("");
    }
}
