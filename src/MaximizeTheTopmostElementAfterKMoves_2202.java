public class MaximizeTheTopmostElementAfterKMoves_2202 {
    // Time: O(N), Space: O(N)
    public static int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            if (k % 2 != 0) {
                return -1;
            }
            return nums[0];
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            int stepsConsumed = i;
            stepsConsumed = k - stepsConsumed;

            if (stepsConsumed >= 0 && stepsConsumed != 1) {
                ans = Math.max(ans, nums[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumTop(new int[]{5, 2, 2, 4, 0 ,6}, 4));
        System.out.println(maximumTop(new int[]{2}, 1));
    }
}
