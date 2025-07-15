/**
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
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
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">LeetCode</a>
 */
class Solution {

    public ListNode reverseList(ListNode head) {
        return reverseList(null, head);
    }

    public ListNode reverseList(ListNode node1, ListNode node2) {
        if (node2 == null) return node1;
        ListNode node2Next = node2.next;
        node2.next = node1;
        return reverseList(node2, node2Next);
    }

}
