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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; 
        while(head!=null){
            // step 1: save head.next value;
            ListNode next = head.next; 
            // step 2: break link between head and head.next
            head.next = prev; 
            prev = head;
            head = next;
        }
        return prev;
    }
}
