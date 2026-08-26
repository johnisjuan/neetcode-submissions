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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode dummy = new ListNode(0);

        dummy.next = head;
        ListNode prev = dummy;

        for(int i = 0;i<left-1;++i) prev = prev.next;

        ListNode subHead = prev.next;
        ListNode subTail = subHead;

        for(int i = 0;i<right - left;++i){
            subTail = subTail.next;
        }

        ListNode next = subTail.next;
        subTail.next = null;
        prev.next = reverseList(subHead);
        subHead.next = next;

        return dummy.next;
    }

    private ListNode reverseList(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){

            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }
        return prev;
    }
}