import java.util.LinkedList;
import java.util.Queue;

public class DetonateTheMaximumBombs_2101 {
    public static int maximumDetonation(int[][] bombs) {
        int max = 0;
        //iterate through each bomb and keep track of max
        for (int i = 0; i < bombs.length; i++) {
            boolean[] visited = new boolean[bombs.length];
            int count = 1;
            int bfsCount = bfs(bombs, visited, i, count);
            max = Math.max(max, bfsCount);
        }
        return max;
    }

    private static int bfs(int[][] bombs, boolean[] visited, int index, int count){
        visited[index] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        while (!queue.isEmpty()) {
            int next = queue.poll();
            for (int pos = 0; pos < bombs.length; pos++) { //search for bombs to detonate
                if (!visited[pos] && isInRange(bombs[next], bombs[pos])) {
                    visited[pos] = true;
                    count++;
                    queue.offer(pos);
                }
            }
        }

        return count;
    }

    //use the distance between two points formula
    //then check if curr bomb radius is greater than the distance; meaning we can detonate the second bombs
    private static boolean isInRange(int[] point1, int[] point2) {
        long dx = point1[0] - point2[0];
        long dy = point1[1] - point2[1];
        long radius = point1[2];

        long distance =  dx * dx + dy * dy;
        return distance <= radius * radius;
    }

    public static void main(String[] args) {
        System.out.println(maximumDetonation(new int[][]{
            {2, 1, 3},
            {6, 1, 4}
        }));

        System.out.println(maximumDetonation(new int[][]{
            {1, 1, 5},
            {10, 10, 5}
        }));

        System.out.println(maximumDetonation(new int[][]{
            {1, 2, 3},
            {2, 3, 1},
            {3, 4, 2},
            {3, 4, 2},
            {3, 4, 2},
        }));
    }
}
