
class Solution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        Stack<Integer> stack= new Stack();
        ArrayList<Integer> res= new ArrayList<>();
        boolean[] v= new boolean[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(!v[i])
                dfs(i, v, adj, stack);
        }
        
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
    
    static void dfs(int node,boolean[] v, ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack) {
        // Your code here
        v[node]=true;
        for(int neibh:adj.get(node)){
            if(!v[neibh])
                dfs(neibh, v, adj, stack);
        }
        stack.push(node);
    }
}
