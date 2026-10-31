package week11.class_problems;

import java.util.Scanner;

public class BestSingleTradeProfit {

    static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, profit = 0;

        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }

        return profit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++)
            prices[i] = sc.nextInt();

        System.out.println(maxProfit(prices));

        sc.close();
    }
}