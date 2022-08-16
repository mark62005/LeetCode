package arrays._047_permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII_047 {
    // Time: O(N*N!), Space: O(2N)
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
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
            if (visited[i] ||
                (i > 0 && nums[i] == nums[i-1] && !visited[i -1])
            ) {
                continue;
            }

            visited[i] = true;
            tempList.add(nums[i]);
            permuteHelper(result, tempList, nums, visited);
            tempList.remove(tempList.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 2, 3}));
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }
}
