package week11.class_problems;

import java.util.*;

public class SpiralOrderTraversal {

    static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> result = new ArrayList<>();

        int top = 0, bottom = grid.length - 1;
        int left = 0, right = grid[0].length - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++)
                result.add(grid[top][i]);
            top++;

            for (int i = top; i <= bottom; i++)
                result.add(grid[i][right]);
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    result.add(grid[bottom][i]);
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    result.add(grid[i][left]);
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(), n = sc.nextInt();
        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        System.out.println(spiralOrder(grid));

        sc.close();
    }
}