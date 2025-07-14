/**
 * # Problem Descriptions
 * 
 * ## [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)
 * 
 * 206. Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 * ---
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 
 */
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