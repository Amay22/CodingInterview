
package LinkedLists;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static LLNode mergeKLists(ArrayList<LLNode> lists) {
        if (lists.isEmpty()) {
            return null;
        }
        //PriorityQueue is a sorted queue
        PriorityQueue<LLNode> pq = new PriorityQueue<>(lists.size(), (LLNode a, LLNode b) -> {
            if (a.val > b.val) {
                return 1;
            } else if (a.val == b.val) {
                return 0;
            } else {
                return -1;
            }
        });
        //add first node of each list to the queue
        for (LLNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        LLNode head = new LLNode(0);
        LLNode p = head;
        while (pq.size() > 0) {
            LLNode temp = pq.poll();
            //poll() retrieves and removes the head of the queue - q.
            p.next = temp;
            //keep adding next element of each list
            if (temp.next != null) {
                pq.add(temp.next);
            }
            p = p.next;
        }
        return head.next;
    }
    public static void main(String[] args) {
        LLNode node1 = new LLNode(2);
        node1.next = new LLNode(4);
        node1.next.next = new LLNode(5);
        LLNode node2 = new LLNode(3);
        node2.next = new LLNode(6);
        node2.next.next = new LLNode(9);
        LLNode node3 = new LLNode(0);
        node3.next = new LLNode(1);
        node3.next.next = new LLNode(7);
        node3.next.next.next = new LLNode(8);
        ArrayList<LLNode> lists = new ArrayList<>();
        lists.add(node1);
        lists.add(node2);
        lists.add(node3);
       
                 LLNode ans =  mergeKLists(lists) ;
        while (ans != null) {
            System.out.print(ans.val+" ,");
            ans = ans.next;
        }
        System.out.println("");
    }
}

