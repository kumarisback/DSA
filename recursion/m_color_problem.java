class solve {
    public boolean isSafe(int u,boolean[][] graph,int col,int[] color,int n){
        for(int i = 0;i<n;i++){
            if(graph[u][i] && color[i]==col) return false;
        }
        return true;
    }
    
    public boolean solve(int u,boolean[][] graph,int m,int n,int[] color){
        if(u==n) return true;
        for(int i = 1;i<=m;i++){
            if(isSafe(u,graph,i,color,n)){
                color[u] = i;
                if(solve(u+1,graph,m,n,color)) return true;
                color[u] = 0;
            }
        }
        return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] color = new int[n];
        if(solve(0,graph,m,n,color)) return true;
        return false;
    }
}
