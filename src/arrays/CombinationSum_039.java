package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_039 {
    // Time: O(N * 2^(N-1)), Space: O(Target/Min Value in Array)
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return result;
        }
        // Only benefit of sorting is that we can break early in the recursion if the
        // current number is greater than the remaining target.
        Arrays.sort(candidates);
        combinationSumHelper(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void combinationSumHelper(int[] candidates, int start, int target, List<Integer> tempList, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            tempList.add(candidates[i]);
            combinationSumHelper(candidates, i, target - candidates[i], tempList, result);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(combinationSum(new int[]{2}, 1));
    }
}
