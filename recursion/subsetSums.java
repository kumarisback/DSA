class Solution{
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){

        ArrayList<Integer> l=new ArrayList<>();
        recursion(arr,N,0,0,l);
        Collections.sort(l);
        return l;
    }
    
    void recursion(ArrayList<Integer> arr, int N, int itr,int sum,ArrayList<Integer> l ){
        if(itr==N){
            l.add(sum);
            return ;
        }
        recursion(arr, N,itr+1,sum+arr.get(itr), l);
        
        recursion(arr, N,itr+1,sum,l);
        
    }
}
