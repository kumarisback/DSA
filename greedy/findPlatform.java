class Solution
{
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plt=0;
        int max=0;
        int i=0,j=0;
        while(i<n && j<n){
            if(arr[i]>dep[j]){
                plt--;
                j++;
            }
            else{
                plt++;
                i++;
            }
            if(plt>max) max=plt;
        }
        return max;
    }
    
}
