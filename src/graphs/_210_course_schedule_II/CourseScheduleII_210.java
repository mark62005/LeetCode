package graphs._210_course_schedule_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseScheduleII_210 {
    // Time: O(V+E), Space: O(V+E)
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegrees = new int[numCourses];
        for (int[] edge : prerequisites) {
            indegrees[edge[0]] += 1;
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> startingVertices = new ArrayList<>();
        for (int v = 0; v < numCourses; v++) {
            if (indegrees[v] == 0) {
                startingVertices.add(v);
            }
        }

        List<Integer> results = new ArrayList<>();
        for (Integer v : startingVertices) {
            dfs(v, adj, indegrees, results);
        }

        int[] answer = results.stream().mapToInt(i -> i).toArray();
        return results.size() == numCourses ? answer : new int[0];
    }

    private static void dfs(int u, List<List<Integer>> adj, int[] indegrees, List<Integer> results) {
        results.add(u);
        for (Integer v : adj.get(u)) {
            indegrees[v] -= 1;
            if (indegrees[v] == 0) {
                dfs(v, adj, indegrees, results);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(findOrder(1, new int[][]{})));
        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }
}
