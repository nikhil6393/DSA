class Solution {
    static class Pair {
        int dist; // Stores x^2 + y^2
        int[] point;

        public Pair(int dist, int[] point) {
            this.dist = dist;
            this.point = point;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        // Min-heap sorted by distance in ascending order
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));

        for (int[] point : points) {
            int dist = calcDistance(point[0], point[1]);
            minHeap.offer(new Pair(dist, point));
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            Pair curr = minHeap.poll();
            ans[i] = curr.point;
        }

        return ans;
    }

    private int calcDistance(int x, int y) {
        return x * x + y * y;
    }
}