/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0){
            return null;
        }

        ListNode merged = lists[0];

        for (int i = 1; i < lists.length; i++) {
            merged = merge(merged, lists[i]);
        }

        return merged;

    }

    private ListNode merge(ListNode head1, ListNode head2){
        
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }

        ListNode newHead;
        
        if(head1.val <= head2.val){
            newHead = head1;
            head1 = head1.next;
        } else {
            newHead = head2;
            head2 = head2.next;
        }

        ListNode temp = newHead;

        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if(head1 == null){
            temp.next = head2;
        } else {
            temp.next = head1;
        }

        return newHead;
    }
}
