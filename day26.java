import java.util.*;

public class day26 {
    
    public static boolean hasCycle(int V, int[][] edges) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]); 
        }

        boolean[] visited = new boolean[V];

        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(graph, visited, i, -1)) {
                    return true; 
                }
            }
        }
        return false; 
    }

    private static boolean dfs(List<List<Integer>> graph, boolean[] visited, int current, int parent) {
        visited[current] = true;

        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                if (dfs(graph, visited, neighbor, current)) {
                    return true;
                }
            } else if (neighbor != parent) {
                
                return true;
            }
        }
        return false;
    }

    
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 4},
            {4, 0}
        };

        boolean result = hasCycle(V, edges);
        System.out.println(result); 
    }
}
