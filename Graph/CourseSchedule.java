import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build the adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph.get(prereq).add(course);
        }

        // Sets to track visited nodes and the current recursion path
        Set<Integer> visited = new HashSet<>();
        Set<Integer> path = new HashSet<>();

        // Perform DFS for each course
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, graph, visited, path)) {
                return false; // Cycle detected
            }
        }
        return true; // No cycle, all courses can be completed
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> path) {
        if (path.contains(course)) {
            return false; // Cycle detected
        }
        if (visited.contains(course)) {
            return true; // Already processed, no cycle from this node
        }

        // Mark this node as being visited in the current path
        path.add(course);

        // Visit all neighbors
        for (int neighbor : graph.get(course)) {
            if (!dfs(neighbor, graph, visited, path)) {
                return false;
            }
        }

        // Remove from the current path and mark as fully processed
        path.remove(course);
        visited.add(course);

        return true;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}, {0, 3}}; // This creates a cycle

        if (cs.canFinish(numCourses, prerequisites)) {
            System.out.println("All courses can be completed.");
        } else {
            System.out.println("Cannot complete all courses due to a cycle.");
        }
    }
}
