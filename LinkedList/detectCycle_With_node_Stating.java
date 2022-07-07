 public ListNode detectCycle(ListNode head) {
        if(head==null ||head.next==null) return null;
        ListNode incrementBy1=head;
        ListNode incrementBy2=head;
        ListNode temp=head;
        
        while(incrementBy2.next!=null && incrementBy2.next.next!=null){
            incrementBy1=incrementBy1.next;
            incrementBy2=incrementBy2.next.next;
            if(incrementBy2==incrementBy1){
                 while(incrementBy1!=temp){
                    incrementBy1=incrementBy1.next;
                    temp=temp.next;
                }
                return temp;
            }
        }  
        return null;
    }
