import utils.UnionFind;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence_128 {
    public static int longestConsecutive(int[] nums) {
        UnionFind unionFind = new UnionFind(nums.length);

        Map<Integer,Integer> map = new HashMap<>(); // <value,index>
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            map.put(nums[i], i);
            if (map.containsKey(nums[i]+1)) {
                unionFind.union(i,map.get(nums[i]+1));
            }
            if (map.containsKey(nums[i]-1)) {
                unionFind.union(i,map.get(nums[i]-1));
            }
        }

        int result = Integer.MIN_VALUE;
        for (int size : unionFind.getSize()) {
            result = Math.max(result, size);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
