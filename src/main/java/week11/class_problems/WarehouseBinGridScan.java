package week11.class_problems;

import java.util.Scanner;

public class WarehouseBinGridScan {

    static int[] warehouseSummary(int[][] grid) {
        int total = 0, max = -1, row = 0, col = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];

                if (grid[i][j] > max) {
                    max = grid[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        return new int[]{total, row, col};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(), n = sc.nextInt();
        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int[] result = warehouseSummary(grid);

        System.out.println("Total: " + result[0]);
        System.out.println("Max Coordinate: (" + result[1] + ", " + result[2] + ")");

        sc.close();
    }
}