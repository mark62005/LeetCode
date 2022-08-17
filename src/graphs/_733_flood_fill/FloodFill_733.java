package graphs._733_flood_fill;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill_733 {

    static class Square {
        int x;
        int y;

        public Square(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        int[][] groupMap = new int[image.length][image.length];
        System.arraycopy(image, 0, groupMap, 0, image.length);

        for (int[] row : image) {
            for (int y = 0; y < image.length; y++) {
                if (row[y] == originalColor) {
                    bfs(sc, sr, originalColor, color, image.length, image, groupMap);
                }
            }
        }

        return groupMap;
    }

    private static void bfs(int x, int y, int originalColor, int newColor, int n, int[][] image, int[][] groupMap) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{-1, 1, 0, 0};

        Queue<Square> queue = new LinkedList<>();
        queue.offer(new Square(x, y));
        groupMap[y][x] = newColor;

        while (!queue.isEmpty()) {
            Square next = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (image[ny][nx] == originalColor && groupMap[ny][nx] != newColor) {
                        queue.offer(new Square(nx, ny));
                        groupMap[ny][nx] = newColor;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 0)));
    }
}
