class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // indegree[i] = number of prerequisites for course i
        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];

            adj.get(prerequisite).add(course);
            indegree[course]++;
        }

        // Add courses with no prerequisites
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // BFS
        int count = 0;

        while (!q.isEmpty()) {
            int node = q.remove();
            count++;

            for (int next : adj.get(node)) {

                indegree[next]--;

                // All prerequisites completed
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        // If all courses are processed, no cycle exists
        return count == numCourses;
    }
}