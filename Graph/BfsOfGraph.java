class Solution {
    
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> res= new ArrayList<>();
        boolean[] v = new boolean[V];
        Queue<Integer> q= new LinkedList<>();
        q.offer(0);
        v[0]=true;
        
        while(!q.isEmpty())
        {
                int node= q.poll();
                res.add(node);
                
                for(int i :adj.get(node)){
                    if(!v[i]){
                        v[i]= true;
                        q.offer(i);
                    }
                }
        }   
        return res;
    }
}
