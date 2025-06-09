
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode dummyHead = new ListNode(-1);
        ListNode currentNode = dummyHead;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next; // skip the dummy head
    }

}