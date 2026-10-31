package week10.assignment_problems;

import java.util.Scanner;
import java.util.Arrays;

public class DutyRosterRotation {

    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        k = k % n;

        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            int newPosition = (int) ((i + k) % n);
            rotated[newPosition] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        long k = sc.nextLong();

        String[] result = rotateRoster(names, k);

        System.out.println(Arrays.toString(result));

        sc.close();
    }
}