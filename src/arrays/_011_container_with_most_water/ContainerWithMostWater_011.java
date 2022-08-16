package arrays._011_container_with_most_water;

public class ContainerWithMostWater_011 {
    // Time: O(N), Space: O(1)
    public static int maxArea(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int maxArea = 0;

        while (leftPointer < rightPointer) {
            int potentialWidth = rightPointer - leftPointer;
            int potentialHeight = Math.min(height[leftPointer], height[rightPointer]);
            int area = potentialWidth * potentialHeight;
            maxArea = Math.max(maxArea, area);

            if (height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            } else if (height[leftPointer] > height[rightPointer]) {
                rightPointer--;
            } else {
                leftPointer++;
                rightPointer--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 2, 4, 3})); // 4
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));// 49
    }
}
