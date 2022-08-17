package graphs._997_find_the_town_judge;

public class FindTheTownJudge_997 {
    // Time: O(2N), Space: O(N)
    public static int findJudge(int n, int[][] trust) {
        int[] degrees = new int[n + 1];

        for (int[] edge : trust) {
            // the number of persons which that person trust other than themselves
            degrees[edge[0]] -= 1;
            // the number of persons who trust that person
            degrees[edge[1]] += 1;
        }

        for (int i = 1; i < n + 1; i++) {
            // if a person is trusted by (n - 1) number of persons, they will be the judge
            if (degrees[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findJudge(2, new int[][]{{1, 2}}));
        System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
    }
}
