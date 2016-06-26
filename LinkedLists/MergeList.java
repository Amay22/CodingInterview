package LinkedLists;

public class MergeList {

    public static LLNode mergeTwoLists(LLNode l1, LLNode l2) {
        LLNode p1 = l1;
        LLNode p2 = l2;
        LLNode fakeHead = new LLNode(0);
        LLNode p = fakeHead;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return fakeHead.next;
    }
    public static void main(String[] args) {
        LLNode node1 = new LLNode(2);
        node1.next = new LLNode(4);
        node1.next.next = new LLNode(5);
        LLNode node2 = new LLNode(3);
        node2.next = new LLNode(6);
        node2.next.next = new LLNode(9);       
        LLNode ans =  mergeTwoLists(node1, node2) ;
        while (ans != null) {
            System.out.print(ans.val+" ,");
            ans = ans.next;
        }
        System.out.println("");
    }
}

