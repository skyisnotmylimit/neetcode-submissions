class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Find the size of the linked list.
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        
        // If the node to remove is the head
        if (n == size) {
            return head.next;
        }
        
        // Find the node before the one we want to remove.
        int k = size - n;
        temp = head;
        for (int i = 1; i < k; i++) {
            temp = temp.next;
        }
        
        // Remove the nth node from the end.
        temp.next = temp.next.next;
        
        return head;
    }
}
