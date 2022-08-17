package recursions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_054 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Input is invalid");
        }

        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int direction = 0;

        while (top <= bottom && left <= right) {
            switch (direction) {
                case 0 -> { // Right
                    for (int i = left; i <= right; i++) {
                        result.add(matrix[top][i]);
                    }
                    top++;
                }
                case 1 -> { // Down
                    for (int i = top; i <= bottom; i++) {
                        result.add(matrix[i][right]);
                    }
                    right--;
                }
                case 2 -> { // Left
                    for (int i = right; i >= left; i--) {
                        result.add(matrix[bottom][i]);
                    }
                    bottom--;
                }
                case 3 -> { // Top
                    for (int i = bottom; i >= top; i--) {
                        result.add(matrix[i][left]);
                    }
                    left++;
                }
            }
            direction = (direction + 1) % 4;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        }));

        System.out.println(spiralOrder(new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        }));
    }
}
