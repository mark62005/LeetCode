package arrays._046_permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations_046 {
    // Time: O(N*N!), Space: O(2N)
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        permuteHelper(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void permuteHelper(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] visited) {
        // base case
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        // iterative case
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            tempList.add(nums[i]);
            permuteHelper(result, tempList, nums, visited);
            visited[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println(permute(new int[]{0, 1}));
    }
}
