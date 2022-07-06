class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(n==1){
            if(head.next==null)
                return null;
        }
        
        int len=0;
        ListNode temp=head;
        ListNode temp2;
        
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        
        if(n==len){
            return head.next;
        }
        temp=head;
        int size=len-n;
        for(int i=1;i<size;i++){
            temp=temp.next;
        }
        
         temp.next =temp.next.next;
        
        return head;
    }
}
