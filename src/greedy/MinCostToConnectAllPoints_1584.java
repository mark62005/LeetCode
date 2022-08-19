package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToConnectAllPoints_1584 {
    // Prim's MST
    // Time: O((V+E)logV), Space: O(V+E)
    public static int minCostConnectPoints(int[][] points) {
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(num -> num[2]));
        for (int i = 0; i < points.length; i++) {
            int distance = getDistance(points[0], points[i]);
            queue.add(new int[]{0, i, distance});
        }

        boolean[] visited = new boolean[points.length];
        int cost = 0;
        int count = points.length - 1;

        visited[0] = true;
        while (queue.size() > 0 && count > 0) {
            int[] edge = queue.poll();
            int v2 = edge[1];
            int distance = edge[2];

            if (!visited[v2]) {
                cost += distance;
                visited[v2] = true;
                count--;

                for (int i = 0; i < points.length; i++) {
                    if (!visited[i]) {
                        int d = getDistance(points[edge[1]], points[i]);
                        queue.add(new int[]{v2, i, d});
                    }
                }
            }
        }

        return cost;
    }

    private static int getDistance(int[] p1, int[] p2) {
        return Math.abs(p2[0] - p1[0]) + Math.abs(p2[1] - p1[1]);
    }

    public static void main(String[] args) {
        System.out.println(minCostConnectPoints(new int[][]{
            {0, 0},
            {2, 2},
            {3, 10},
            {5, 2},
            {7, 0}
        }));

        System.out.println(minCostConnectPoints(new int[][]{
            {3, 12},
            {-2, 5},
            {-4, 1},
        }));
    }
}
