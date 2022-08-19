public class GasStation_134 {
    // Time: O(N), Space: O(1)
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int currentGaining = 0;
        int totalGaining = 0;
        int candidate = 0;

        for (int i = 0; i < gas.length; i++) {
            currentGaining += gas[i] - cost[i];
            totalGaining += gas[i] - cost[i];

            if (currentGaining < 0) {
                candidate = i+1;
                currentGaining = 0;
            }
        }

        return totalGaining >= 0 ? candidate : -1;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}
