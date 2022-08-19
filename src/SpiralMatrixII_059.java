import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrixII_059 {
    // Time: O(M*N), Space: O(1)
    public static int[][] spiralOrderII(int n) {
        int[][] result = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int num = 1;
        int dir = 0;

        while (top <= bottom && left <= right) {
            switch (dir) {
                case 0 -> { // Left
                    for (int i = left; i <= right; i++) {
                        result[top][i] = num++;
                    }
                    top++;
                }
                case 1 -> { // Down
                    for (int i = top; i <= bottom; i++) {
                        result[i][right] = num++;
                    }
                    right--;
                }
                case 2 -> { // Right
                    for (int i = right; i >= left; i--) {
                        result[bottom][i] = num++;
                    }
                    bottom--;
                }
                case 3 -> { // Up
                    for (int i = bottom; i >= top; i--) {
                        result[i][left] = num++;
                    }
                    left++;
                }
            }
            dir = (dir + 1) % 4;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(spiralOrderII(3)));
        System.out.println(Arrays.deepToString(spiralOrderII(1)));
    }
}
