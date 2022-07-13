class Solution {
    
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);        
        recursion(0,nums,new ArrayList<>());
        return ans;
    }
    
    private  void recursion(int index,int[] nums,ArrayList<Integer> temp){
        ans.add(new ArrayList<>(temp));    
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            recursion(i+1,nums,temp);
            temp.remove(temp.size()-1);   
        }
    }    
}
