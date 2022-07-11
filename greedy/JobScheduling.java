class Solution
{
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,(a,b)->  (b.profit-a.profit));
        
        int max=-1;
        for(int i=0;i<n;i++)
            if(arr[i].deadline>max) max=arr[i].deadline;
        
        int[] res=new int[max+1];
        
        for(int i=1;i<=max;i++)
            res[i]=-1;
            
        int jobs=0;
        int profit=0;
        
        for(int i=0;i<n;i++){
            for(int j=arr[i].deadline;j>=0;j--){
                if(res[j]==-1){
                    res[j]=i;
                    jobs++;
                    profit+=arr[i].profit;
                    break;
                }
            }
        }
        return new int[]{jobs,profit};
    }
}
