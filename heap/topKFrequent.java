class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer,Integer> m=new HashMap();
    for(int i:nums){
        
        m.put(i,m.getOrDefault(i,0)+1);
    }
        
    int result[]=new int[k];

List<Integer> list=new ArrayList(m.keySet());
        
        Collections.sort(list,(a,b)->{return m.get(b)-m.get(a);});
            
            for(int i=0;i<k;i++){
                
                result[i]=list.get(i);
                
            }



    return result;
    }
}
