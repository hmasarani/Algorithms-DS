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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //always start with a dummy node: 
        ListNode dummy = new ListNode(0);
        // make it point to head; 
        dummy.next = head; 

        // we want to have two pointers, one that goes up to n+1:
        ListNode slow = dummy; 
        ListNode fast = dummy;
        for(int i = 1;i<=n+1;i++){
            fast = fast.next; 
        }
        //move slow until fast is null -- this would make slow be at the node before nth
        while(fast != null){
            slow = slow.next; 
            fast = fast.next; 
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
