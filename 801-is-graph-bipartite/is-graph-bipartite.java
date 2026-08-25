class Solution {

    // This variable stores whether the graph is bipartite or not.
    static boolean ans;

    // BFS function to check one connected component.
    public void bfs(int i, int[][] adj, int[] visited) {

        // Create a queue for BFS.
        Queue<Integer> q = new LinkedList<>();

        // Add the starting node to the queue.
        q.add(i);

        // Process nodes until the queue becomes empty.
        while (q.size() > 0) {

            // Remove the front node from the queue.
            int front = q.remove();

            // Get the color of the current node.
            int color = visited[front];

            // Visit all neighbours of the current node.
            for (int ele : adj[front]) {

                // If neighbour has the same color,
                // then the graph is NOT bipartite.
                if (visited[ele] == visited[front]) {

                    // Mark answer as false.
                    ans = false;

                    // Stop BFS because we found a conflict.
                    return;
                }

                // If the neighbour has not been colored yet.
                if (visited[ele] == -1) {

                    // Give the neighbour the opposite color.
                    // If current is 1, neighbour becomes 0.
                    // If current is 0, neighbour becomes 1.
                    visited[ele] = 1 - color;

                    // Add the neighbour to the queue.
                    q.add(ele);
                }
            }
        }
    }

    // Main function to check whether graph is bipartite.
    public boolean isBipartite(int[][] graph) {

        // Number of vertices in the graph.
        int n = graph.length;

        // visited[i] stores the color of node i.
        // -1 = not visited
        //  0 = Blue
        //  1 = Red
        int[] visited = new int[n];

        // Initially, all nodes are unvisited.
        Arrays.fill(visited, -1);

        // Initially assume that the graph is bipartite.
        ans = true;

        // Check every node because the graph can be disconnected.
        for (int i = 0; i < n; i++) {

            // If this node has not been colored yet,
            // start BFS from this node.
            if (visited[i] == -1) {

                // Give the starting node color 1 (Red).
                visited[i] = 1;

                // Run BFS for this connected component.
                bfs(i, graph, visited);

                // If BFS found two adjacent nodes
                // having the same color, return false.
                if (ans == false) {
                    return false;
                }
            }
        }

        // If no conflict was found, graph is bipartite.
        return true;
    }
}