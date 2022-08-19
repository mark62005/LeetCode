import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands_200 {
    public static int numIslands(char[][] grid) {
        int count = 0;
        char[][] islandMap = new char[grid.length][grid[0].length];
        System.arraycopy(grid, 0, islandMap, 0, grid.length);

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    bfs(c, r, grid.length, grid[0].length, grid, islandMap);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(int x, int y, int n, int m, char[][] grid, char[][] islandMap) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{-1, 1, 0, 0};

        Queue<Square> queue = new LinkedList<>();
        queue.offer(new Square(x, y));
        islandMap[y][x] = '0';

        while (!queue.isEmpty()) {
            Square next = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (islandMap[ny][nx] == '1' && grid[ny][nx] == '1') {
                        queue.offer(new Square(nx, ny));
                        islandMap[ny][nx] = '0';
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        }));

        System.out.println(numIslands(new char[][]{
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        }));
    }

    static class Square {
        int x;
        int y;

        public Square() {}
        public Square(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
