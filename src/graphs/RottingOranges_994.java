package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_994 {
    static class Square {
        int x;
        int y;
        public Square(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        int height = grid.length;
        int width = grid[0].length;

        int[][] minutes = new int[height][width];
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                minutes[r][c] = -1;
            }
        }

        Queue<Square> queue = new LinkedList<>();
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new Square(c, r));
                    minutes[r][c] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            Square next = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                if (nx >= 0 && nx < width && ny >= 0 && ny < height) {
                    if (grid[ny][nx] == 1 && minutes[ny][nx] == -1) {
                        minutes[ny][nx] = minutes[next.y][next.x] + 1;
                        queue.offer(new Square(nx, ny));
                    }
                }
            }
        }

        int answer = 0;
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (grid[r][c] == 1 && minutes[r][c] == -1) {
                    return -1;
                }

                if (answer < minutes[r][c]) {
                    answer = minutes[r][c];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        }));

        System.out.println(orangesRotting(new int[][]{
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        }));

        System.out.println(orangesRotting(new int[][]{
            {0, 2}
        }));
    }
}
