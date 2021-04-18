/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlists;

/**
 *
 * @author Amay
 */
public class DeleteDuplicatesSortedList {

    public LLNode deleteDuplicates(LLNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LLNode prev = head;
        LLNode p = head.next;
        while (p != null) {
            if (p.val == prev.val) {
                prev.next = p.next;
                p = p.next;
//no change prev
            } else {
                prev = p;
                p = p.next;
            }
        }
        return head;
    }
}
