class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode resultNode=null;
        while(head!=null){
            ListNode t= new ListNode(head.val);
            t.next=resultNode;
            resultNode=t;
            head=head.next;
        }
        return resultNode;        
    }
}
