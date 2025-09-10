import java.util.*;

public class day27 {

    public static int shortestPath(int V, int[][] edges, int start, int end) {
        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]); // Undirected graph
        }

        // Distance array to keep track of shortest distance from start
        int[] distance = new int[V];
        Arrays.fill(distance, -1); // -1 means unvisited

        // BFS queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distance[start] = 0; // Distance to start node is 0

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // If we reached the end node
            if (current == end) {
                return distance[current];
            }

            // Explore neighbors
            for (int neighbor : graph.get(current)) {
                if (distance[neighbor] == -1) { // Not visited
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        return -1; // No path found
    }

    // Main method to test
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 3},
            {2, 3},
            {3, 4}
        };
        int start = 0;
        int end = 4;

        int result = shortestPath(V, edges, start, end);
        System.out.println(result); // Expected Output: 3
    }
}
