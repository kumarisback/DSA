class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null ) return list1;
        if(list1!=null && list2==null) return list1;
        if(list1==null && list2!=null) return list2;
        
   
        ListNode f= list1;
        ListNode s= list2;
        ListNode head;
        
        if(list1.val<list2.val){
              head= list1;
              f = list1.next;
        }
        else{
             head= list2;
             s= list2.next;
        }
        ListNode result=head;;
        while(f !=null && s!=null){
            if(f.val<s.val){
                head.next=f;
                f=f.next;
            }
            else{
                head.next=s;
                s=s.next;
            }
            head=head.next;
        }
        if(f==null && s!=null){
            head.next=s;
        }
        else{
            head.next=f;
        }
        return result;
    }
}
