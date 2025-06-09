/**
 * ---
 * [https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list]
 * 2095. Delete the Middle Node of a Linked List
 * You are given the head of a linked list. Delete the middle node, and return 
 * the head of the modified linked list.
 * ---
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

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next.next != null && fast.next.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // skip next element
        slow.next = slow.next.next;
        return head;
    }
}