class Solution {
    public ListNode middleNode(ListNode head) {
        
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        temp=head;
        for(int i=0;i<(len/2);i++){
            temp=temp.next;
        }
        return temp;
    }
}
