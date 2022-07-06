public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head==null ||head.next==null) return false;
        ListNode incrementBy1=head;
        ListNode incrementBy2=head;
        
        while(incrementBy2.next!=null && incrementBy2.next.next!=null){
            incrementBy1=incrementBy1.next;
            incrementBy2=incrementBy2.next.next;
            if(incrementBy2==incrementBy1) return true;
        }
        return false;
    }
}
