public class NumberOfProvinces_547 {

    public static int findCircleNum(int[][] isConnected) {
        if (isConnected.length == 0 || isConnected[0].length == 0) {
            return 0;
        }

        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];

        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                dfs(v, visited, isConnected);
                count += 1;
            }
        }
        return count;
    }

    private static void dfs(int start, boolean[] visited, int[][] adjMatrix) {
        visited[start] = true;
        for (int v = 0; v < adjMatrix.length; v++) {
            if (start == v) {
                continue;
            }

            if (!visited[v] && adjMatrix[start][v] == 1) {
                visited[v] = true;
                dfs(v, visited, adjMatrix);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }
}
