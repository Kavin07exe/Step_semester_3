package week11.assignment_problems;

import java.util.*;

public class PrizeTable {

    static int prizeTable(int[] marks) {
        int swaps = 0;

        for (int i = 0; i < marks.length - 1; i++) {
            int max = i;

            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[max])
                    max = j;
            }

            if (max != i) {
                int temp = marks[i];
                marks[i] = marks[max];
                marks[max] = temp;
                swaps++;
            }
        }

        System.out.println(Arrays.toString(marks));
        return swaps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] marks = new int[n];

        for (int i = 0; i < n; i++)
            marks[i] = sc.nextInt();

        System.out.println("Swaps: " + prizeTable(marks));

        sc.close();
    }
}