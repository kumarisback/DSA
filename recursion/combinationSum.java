class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        recursion(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    
    public void recursion(int index,int[] arr,int t,List<List<Integer>> ans,List<Integer> l){
        if(index==arr.length){
            if(t==0)ans.add(new ArrayList<>(l));
            return;
        }
            if(arr[index]<=t){
                l.add(arr[index]);
                recursion(index,arr,t-arr[index],ans,l);
                l.remove(l.size()-1);
            }
          recursion(index+1,arr,t,ans,l);
        
    }
}
