package week11.assignment_problems;

import java.util.*;

public class HeightLineUp {

    static void lineUp(int[] heights) {
        int pass = 1;
        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < heights.length - 1; i++) {
                if (heights[i] > heights[i + 1]) {
                    int temp = heights[i];
                    heights[i] = heights[i + 1];
                    heights[i + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + pass++ + ": " + Arrays.toString(heights));

        } while (swapped);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] heights = new int[n];

        for (int i = 0; i < n; i++)
            heights[i] = sc.nextInt();

        lineUp(heights);
        sc.close();
    }
}