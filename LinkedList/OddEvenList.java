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
    public ListNode oddEvenList(ListNode head) {
          if (head == null) return null; // Handle empty list case
        
        ListNode temp = head;
        ListNode first = new ListNode();
        ListNode f = first;
        ListNode second = new ListNode();
        ListNode s = second;
        boolean flag = true;

        while (temp != null) {
            if (flag) {
                first.next = temp;
                first = first.next;
            } else {
                second.next = temp;
                second = second.next;
            }
            temp = temp.next;
            flag = !flag;
        }
        second.next = null; // Ensure no dangling link in the even list
        first.next = s.next; // Connect the odd list to the even list
        
        return f.next;
    }
}
