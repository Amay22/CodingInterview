
package linkedlists;

public class LoopDetectionBegin {

    public static LLNode FindBeginning(LLNode head) {
        LLNode slow = head;
        LLNode fast = head;

        // Find meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // Error check - there is no meeting point, and therefore no loop
        if (fast == null || fast.next == null) {
            return null;
        }

        /* Move slow to Head. Keep fast at Meeting Point. Each are k steps
         /* from the Loop Start. If they move at the same pace, they must
         * meet at Loop Start. */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Both now point to the start of the loop.
        return fast;
    }

    public static void main(String[] args) {
        LLNode loop = new LLNode(0);
        LLNode node = new LLNode(2);
        node.next = new LLNode(4);
        node.next.next = new LLNode(5);
        node.next.next.next = loop;
        node.next.next.next.next = new LLNode(8);
        node.next.next.next.next.next = new LLNode(9);
        node.next.next.next.next.next.next = loop;
        System.out.println(FindBeginning(node).val);

    }
}
