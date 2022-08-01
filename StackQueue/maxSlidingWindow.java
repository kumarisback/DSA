class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    int n=nums.length;
    int[] ans=new int[n-k+1];

    int r=0,i=0;
    
    Deque<Integer>q=new ArrayDeque();
    
    for(int j=0;j<nums.length;j++){
        
        while(q.size()>0 && q.peekLast()<nums[j]){
            q.pollLast();
        }
        q.offer(nums[j]);
        
        
        if(j-i+1==k){
            ans[r++]=q.peek();
            
            if(q.peek()==nums[i]){
                q.removeFirst();
            }
            i++;
        }
    }
    
    return ans; 
    }
}
