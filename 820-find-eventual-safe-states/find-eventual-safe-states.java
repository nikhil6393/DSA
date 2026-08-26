class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        // Reverse graph banayenge
        // Original: i -> ele
        // Reverse:  ele -> i
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        // Original graph ko reverse kar rahe hain
        for (int i = 0; i < n; i++) {

            for (int ele : graph[i]) {

                // Original edge: i -> ele
                // Reverse graph me: ele -> i
                adj.get(ele).add(i);

                // Original graph me i ki outgoing edge count
                // indegree ki tarah use karenge
                indegree[i]++;
            }
        }

        // Kahn's Algorithm apply karenge
        Queue<Integer> q = new LinkedList<>();

        // Jinke paas outgoing edge nahi hai,
        // woh terminal/safe nodes hain
        // Reverse graph me unka indegree = 0 hoga
        for (int i = 0; i < n; i++) {

            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        // BFS using Kahn's Algorithm
        while (q.size() > 0) {

            int front = q.remove();

            // Ye node safe hai
            ans.add(front);

            // Reverse graph me is node ke neighbours check karo
            for (int ele : adj.get(front)) {

                // Safe node milne ke baad
                // uske previous node ki outgoing edge count reduce karo
                indegree[ele]--;

                // Agar saari outgoing edges safe nodes ki taraf hain,
                // to ye node bhi safe ban jayega
                if (indegree[ele] == 0) {
                    q.add(ele);
                }
            }
        }

        // LeetCode me answer increasing order me chahiye
        Collections.sort(ans);

        return ans;
    }
}