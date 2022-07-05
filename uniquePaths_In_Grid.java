class Solution {
     
    public int uniquePaths(int m, int n) {
        // int ways=0;
        // ways=fill(m,n,0,0);
        // return ways;
        
        
        //combination ways
        int totalways=m+n-2;
        int pickdown=m-1;
        double result=1;
        
        for(int i=1;i<=pickdown;i++){
            result=result*(totalways-pickdown+i)/i;
        }
        return (int)result;
    }
    
//     recursion
    // public int fill(int m,int n ,int i , int j ){
    //     if( ( i==m-1 && j==n-1 )  ){
    //         return 1;
    //     }
    //     if( i>=m ||j>=n) return 0;
    //     else
    //         return fill(m,n,i+1,j)+fill(m,n,i,j+1);
    // }
}
