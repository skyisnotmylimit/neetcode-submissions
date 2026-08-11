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
    private ListNode getMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null) {
            ListNode cur = temp;
            temp = temp.next;
            cur.next = null;
            if(prev == null) {
                prev = cur;
            }
            else {
                cur.next = prev;
                prev = cur;
            }
        }
        return prev;
    }
    public void reorderList(ListNode head1) {
        ListNode middleNode = getMiddle(head1);
        ListNode head2 = middleNode.next;
        middleNode.next = null; 
        head2 = reverse(head2);
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while(temp2 != null) {
            ListNode cur = temp2;
            temp2 = temp2.next;
            ListNode nxtPtr = temp1.next;
            temp1.next = cur;
            cur.next = nxtPtr;
            temp1 = temp1.next.next;
        }
    }
}
