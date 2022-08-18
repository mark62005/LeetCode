package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares_279 {
    // BFS
    // Time: O(V), Space: O(V)
    public static int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> reviewedSet = new HashSet<>();

        if (n > 0) {
            queue.offer(n);
        }

        int result = 0;
        while (!queue.isEmpty()) {
            result++;

            int size = queue.size();
            int val = 0;
            for (int i = 0; i < size; i++) {
                if (queue.peek() != null) {
                    val = queue.poll();
                }
                if (!reviewedSet.add(val)) {
                    continue;
                }

                for (int j = 1; j <= Math.sqrt(val); j++) {
                    if (val - (j * j) == 0) {
                        return result;
                    }
                    queue.offer(val - (j * j));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }
}
