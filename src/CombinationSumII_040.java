import java.util.*;

public class CombinationSumII_040 {
    // Time: O(N * 2^(N-1)), Space: O(Target/Min Value in Array)
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int c : candidates) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        List<Integer> uniqueNumList = new ArrayList<>(countMap.keySet());
        Collections.sort(uniqueNumList);

        combinationSum2Helper(countMap, uniqueNumList, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void combinationSum2Helper(HashMap<Integer, Integer> countMap, List<Integer> uniqueNumList,
                                              int start, int target, List<Integer> tempList, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < uniqueNumList.size(); i++) {
            int num = uniqueNumList.get(i);
            int count = countMap.get(num);
            if (count == 0) {
                continue;
            }
            if (num > target) {
                break;
            }

            tempList.add(num);
            countMap.put(num, count - 1);
            combinationSum2Helper(countMap, uniqueNumList, i, target - num, tempList, result);
            tempList.remove(tempList.size() - 1);
            countMap.put(num, count);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum2(new int[]{2, 3, 5}, 8));
        System.out.println(combinationSum2(new int[]{2}, 1));
    }
}
