import java.util.ArrayList;
import java.util.List;

public class CourseSchedule_207 {
    // Time: O(V+E), Space: O(V+E)
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
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

        for (Integer v : startingVertices) {
            dfs(v, adj, indegrees);
        }

        for (int indegree : indegrees) {
            if (indegree != 0) {
                return false;
            }
        }

        return true;
    }

    private static void dfs(int u, List<List<Integer>> adj, int[] indegrees) {
        for (Integer v : adj.get(u)) {
            indegrees[v] -= 1;
            if (indegrees[v] == 0) {
                dfs(v, adj, indegrees);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
