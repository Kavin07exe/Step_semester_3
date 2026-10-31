package week11.assignment_problems;

import java.util.*;

public class DiceThrowTally {

    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int roll : rolls)
            count[roll]++;

        System.out.print("Counts: ");
        for (int i = 1; i <= 6; i++)
            System.out.print(i + ":" + count[i] + " ");

        System.out.println();

        int[] sorted = new int[rolls.length];
        int k = 0;

        for (int i = 1; i <= 6; i++)
            for (int j = 0; j < count[i]; j++)
                sorted[k++] = i;

        return sorted;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] rolls = new int[n];

        for (int i = 0; i < n; i++)
            rolls[i] = sc.nextInt();

        System.out.println("Sorted: " + Arrays.toString(diceSort(rolls)));

        sc.close();
    }
}