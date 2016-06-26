
package LinkedLists;

public class KthLastNode {
    public static LLNode nthNodeFromEndIterative(LLNode head, int n) {
        if(head == null){
            return null;
        }
        LLNode nth = head;
        // Get nth from the start
        for (int i = 0; i < n; i++) {
            if(nth.next == null){
                return null;
            }
            nth = nth.next;
        }
        // Move both the head and nth node so the difference between them is n
        // Thus we get the nth node from the end
        while(nth != null){
            head = head.next;
            nth = nth.next;
        }
        return head;
    }  
    
    
    public static void main(String[] args) {
        LLNode node1 = new LLNode(2);
        node1.next = new LLNode(4);
        node1.next.next = new LLNode(3);
        node1.next.next.next = new LLNode(5);
        node1.next.next.next.next = new LLNode(7);
        node1.next.next.next.next.next = new LLNode(6);
        System.out.println(nthNodeFromEndIterative(node1,3));
//        KthLastNode k =new KthLastNode();
//        System.out.println(k.nthNodeFromEnd(node1,3));
    }
}
