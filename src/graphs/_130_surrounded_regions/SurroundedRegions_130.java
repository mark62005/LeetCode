package graphs._130_surrounded_regions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions_130 {
    // Time: O(M + N)
    public static void solve(char[][] board) {
        char[][] regionMap = new char[board.length][board.length];
        System.arraycopy(board, 0, regionMap, 0, board.length);

        for (int r = 1; r < board.length - 1; r++) {
            for (int c = 1; c < board.length - 1; c++) {
                if (board[r][c] == 'O') {
                    bfs(c, r, board.length, board, regionMap);
                }
            }
        }
    }

    private static void bfs(int x, int y, int n, char[][] board, char[][] regionMap) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{-1, 1, 0, 0};

        Queue<Square> queue = new LinkedList<>();
        queue.offer(new Square(x, y));
        regionMap[y][x] = 'X';

        while (!queue.isEmpty()) {
            Square next = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                if (nx > 0 && nx < n - 1 && ny > 0 && ny < n - 1) {
                    if (regionMap[ny][nx] == 'O' && board[ny][nx] == 'O') {
                        queue.offer(new Square(nx, ny));
                        regionMap[ny][nx] = 'X';
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] b1 = new char[][]{
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        solve(b1);
        System.out.println(Arrays.deepToString(b1));
    }

    static class Square {
        int x;
        int y;

        public Square(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
