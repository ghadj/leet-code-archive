class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = head;
        ListNode nextnext;

        while(next != null) {
            nextnext = next.next;
            next.next = prev;
            prev = next;
            next = nextnext;
        }

        return prev;
    }
}