class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans= new ArrayList<>();
        List<String> temp=new ArrayList<>();
        recursion(s,0,temp,ans);
        return ans;
    }
    
    boolean isPalidrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
    
    void recursion(String s,int index, List<String> temp, List<List<String>> ans){
        if(index==s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=index;i<s.length();i++){
            if(isPalidrome(s,index,i)){
                temp.add(s.substring(index,i+1));
                recursion(s,i+1,temp,ans);
                temp.remove(temp.size()-1);
            }
        }
    }
}
