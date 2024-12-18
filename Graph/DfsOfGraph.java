import java.util.ArrayList;

class Solution {
    // Helper function for the recursive DFS traversal
    public void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        // Mark the current node as visited
        visited[node] = true;
        result.add(node); // Add the node to the result list
        
        // Recur for all adjacent nodes
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, adj, visited, result);
            }
        }
    }

    // Function to return a list containing the DFS traversal of the graph
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>(); // To store the traversal order
        boolean[] visited = new boolean[V]; // Visited array to track visited nodes
        
        // Perform DFS starting from vertex 0 (assuming 0 as the start node)
        dfsHelper(0, adj, visited, result);
        
        return result;
    }
}

