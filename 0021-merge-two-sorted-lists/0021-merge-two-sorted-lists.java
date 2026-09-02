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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        // Traverse through both lists while neither is exhausted
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1; // Link to list1 node
                list1 = list1.next;   // Move list1 pointer forward
            } else {
                current.next = list2; // Link to list2 node
                list2 = list2.next;   // Move list2 pointer forward
            }
            current = current.next;   // Advance the tail pointer of our merged list
        }
        
        // If elements remain in either list, append them directly
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        
        // The real head of the merged list is the next node after the dummy
        return dummy.next;
    }
}