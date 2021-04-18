
package linkedlists;

public class Add2NumReversed {

    // NOTE : the input parameters and output LL is reversed.
    public static LLNode addTwoNumbers(LLNode l1, LLNode l2) {
        int carry = 0;
        LLNode head = new LLNode(0);
        LLNode sum = head;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            sum.next = new LLNode(carry % 10);
            sum = sum.next;
            carry /= 10;
        }
        sum.next = carry == 1 ? new LLNode(1) : null;
        return head.next;
    }

    public static LLNode addTwo(LLNode l1, LLNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        LLNode head = new LLNode(0);
        LLNode cur = head;
        int advance = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + advance;
            advance = sum / 10;
            sum = sum % 10;
            cur.next = new LLNode(sum);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null){
            if(advance != 0)
                cur.next = addTwo(l1, new LLNode(advance));
            else
                cur.next = l1;
        }else if(l2 != null){
            if(advance != 0)
                cur.next = addTwo(l2, new LLNode(advance));
            else
                cur.next = l2;
        }else if(advance != 0){
            cur.next = new LLNode(advance);
        }
        return head.next;
    }
    public static void main(String[] args) {
        LLNode node1 = new LLNode(2);
        node1.next = new LLNode(4);
        node1.next.next = new LLNode(3);
        LLNode node2 = new LLNode(9);
        node2.next = new LLNode(6);
        node2.next.next = new LLNode(9);
        node2.next.next.next = new LLNode(8);
        LLNode ans = addTwoNumbers(node1, node2);
        while (ans != null) {
            System.out.print(ans.val);
            ans = ans.next;
        }
        System.out.println("");
        ans = addTwo(node1, node2);
        while (ans != null) {
            System.out.print(ans.val);
            ans = ans.next;
        }
        System.out.println();
    }
}
