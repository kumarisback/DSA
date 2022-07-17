class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        recursion(0,nums,ans);
        return ans;
    }
    
    
    void recursion(int index ,int[] nums, List<List<Integer>> ans){
        if(index==nums.length){
            ans.add(Arrays.stream(nums).boxed().toList());
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            recursion(index+1,nums,ans);
            swap(i,index,nums);
        }
    }
    
    void swap(int i ,int j, int[] nums){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
