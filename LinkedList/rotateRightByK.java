class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        int length=0;
        
        if(head==null) return null;
        
        ListNode t=head,last=null;
        while(t!=null){
            if(t.next==null) last=t;
            t=t.next;
            length++;
            
        }
        
        int times=k%length;
        if(times==0) return head;
        last.next=head;
        t=head;
        
        for(int i=0;i<length-times-1;i++){
            t=t.next;
        }
        head=t.next;
        t.next=null;
        return head;
    }
}
