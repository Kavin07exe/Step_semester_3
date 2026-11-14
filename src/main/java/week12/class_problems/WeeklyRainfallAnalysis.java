package week12.class_problems;

import java.util.Scanner;

public class WeeklyRainfallAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] rain = new double[7];
        double total = 0, max = -1;
        int wettestDay = 0, dryDays = 0;

        for (int i = 0; i < 7; i++) {
            rain[i] = sc.nextDouble();
            total += rain[i];

            if (rain[i] > max) {
                max = rain[i];
                wettestDay = i + 1;
            }

            if (rain[i] == 0)
                dryDays++;
        }

        System.out.print("Rainfall (mm): ");
        for (int i = 0; i < 7; i++)
            System.out.print(rain[i] + " ");

        System.out.println("\nTotal Rainfall: " + total + " mm");
        System.out.printf("Average Rainfall: %.2f mm%n", total / 7);
        System.out.println("Wettest Day: Day " + wettestDay + " (" + max + " mm)");
        System.out.println("Total Dry Days: " + dryDays);

        sc.close();
    }
}