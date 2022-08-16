package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum_001 {
    // time: O(N), Space: O(N)
    public static int[] twoSum(int[] nums, int target) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            int match = target - num;
            if (numsSet.contains(match)) {
                return new int[] {match, num};
            }
            numsSet.add(num);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
