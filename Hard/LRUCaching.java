package Hard;

import java.util.HashMap;

class DoubleLinkedListNode {

    public int val;
    public int key;
    public DoubleLinkedListNode pre;
    public DoubleLinkedListNode next;

    public DoubleLinkedListNode(int _key, int _value) {
        val = _value;
        key = _key;
    }
}

public class LRUCaching {

    private final HashMap<Integer, DoubleLinkedListNode> map = new HashMap<>();
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode end;
    private final int capacity;
    private int len;

    public LRUCaching(int _capacity) {
        capacity = _capacity;
        len = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode latest = map.get(key);
            removeNode(latest);
            setHead(latest);
            return latest.val;
        } else {
            return -1;
        }
    }

    public void removeNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode cur = node;
        DoubleLinkedListNode pre = cur.pre;
        DoubleLinkedListNode post = cur.next;
        if (pre != null) {
            pre.next = post;
        } else {
            head = post;
        }
        if (post != null) {
            post.pre = pre;
        } else {
            end = pre;
        }
    }

    public void setHead(DoubleLinkedListNode node) {
        node.next = head;
        node.pre = null;
        if (head != null) {
            head.pre = node;
        }
        head = node;
        if (end == null) {
            end = node;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode oldNode = map.get(key);
            oldNode.val = value;
            removeNode(oldNode);
            setHead(oldNode);
        } else {
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
            if (len < capacity) {
                setHead(newNode);
                map.put(key, newNode);
                len++;
            } else {
                map.remove(end.key);
                end = end.pre;
                if (end != null) {
                    end.next = null;
                }
                setHead(newNode);
                map.put(key, newNode);
            }
        }
    }
    
    public static void main(String[] args) {
        LRUCaching lru = new LRUCaching(8);
//        lru
    }
}

