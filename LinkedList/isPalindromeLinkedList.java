  public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        
        while(fast.next != null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //reverse the likedlist
            
        ListNode temp=slow.next;
        ListNode next=null;
        ListNode prev=null;
        while(temp!=null){
            next= temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        slow.next=prev;
        slow=slow.next;
        
        while(slow!=null){
           
            if(slow.val!=head.val)
                return false; 
            slow=slow.next;
            head=head.next;
        }
        return true;
    }
