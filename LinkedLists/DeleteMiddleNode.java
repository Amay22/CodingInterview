
package LinkedLists;


public class DeleteMiddleNode {

    public static boolean deleteNode(LLNode n) {
        if (n == null || n.next == null) {
            return false; // Failure
        }
        LLNode next = n.next;
        n.val = next.val;
        n.next = next.next;
        return true;
    }
}
