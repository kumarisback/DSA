class Solution {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        // Write your code here
        
        int[] dist = new int[V];
        
        for(int i=0;i<V;i++){
            dist[i]=(int)1e-8;
        }
        dist[src] = 0;
        
        for(int i=0;i<V-1;i++){   // THIS IS NEEDED BECAUSE ON COMPLETE of each FULL EDGED SOME NEW SHORTEST 
                                // PATH WE GET THAN WE WILL USE AGAIN FROM START TO MAKE SURE IF ANY NEW PATH WE CAN FIND FOR EXISTING TO MAKE IT SHORTEST.
            
            for(int j=0;j<edges.length;j++){
                int sro =edges[j][0];
                int dest =edges[j][1];
                int wight =edges[j][2];
                
                if(dist[sro]+wight<dist[dest]){
                    dist[dest]=dist[sro]+wight;
                }
            }
        }
        
        for(int j=0;j<edges.length;j++){
                int sro =edges[j][0];
                int dest =edges[j][1];
                int wight =edges[j][2];
                
                if(dist[sro]+wight<dist[dest]){
                    dist[dest]=(int)1e-8;
                }
            }
        
        
        
        return dist;
        
        
    }
}
