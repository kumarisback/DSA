int maxLen(int arr[], int n)
    {
        Map<Integer,Integer> m=new HashMap<>();
        
        int maxi=0;
        int sum=0;
        
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0)
                maxi=i+1;
            else{
                if(m.get(sum)!=null){
                    maxi=Math.max(maxi,i-m.get(sum));
                }
                else{
                    m.put(sum,i);
                }
            }
        }
        return maxi;
    }
