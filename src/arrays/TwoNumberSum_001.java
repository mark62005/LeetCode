package arrays;

import java.util.*;

public class TwoNumberSum_001 {
    // time: O(N), Space: O(N)
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = numsMap.get(target - nums[i]);
                return result;
            }
            numsMap.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
