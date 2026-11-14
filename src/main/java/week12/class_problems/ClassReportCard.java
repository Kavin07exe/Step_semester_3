package week12.class_problems;

import java.util.Scanner;

class Student {
    private String name;
    private int a, b, c;

    Student(String name) {
        this.name = name;
    }

    boolean setMarks(int a, int b, int c) {
        if (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100)
            return false;

        this.a = a;
        this.b = b;
        this.c = c;
        return true;
    }

    int total() {
        return a + b + c;
    }

    double average() {
        return total() / 3.0;
    }

    String grade() {
        double avg = average();

        if (avg >= 80) return "A";
        if (avg >= 70) return "B";
        if (avg >= 60) return "C";
        if (avg >= 40) return "D";
        return "F";
    }

    public String toString() {
        return name + " total=" + total()
                + " avg=" + String.format("%.2f", average())
                + " grade=" + grade();
    }
}

public class ClassReportCard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student[] students = new Student[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            Student s = new Student(name);

            if (s.setMarks(a, b, c))
                students[count++] = s;
            else
                System.out.println(name + " skipped: marks must be 0 to 100");
        }

        int passes = 0;

        for (int i = 0; i < count - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < count - i - 1; j++) {
                if (students[j].total() < students[j + 1].total()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                    swapped = true;
                }
            }

            passes++;
            if (!swapped)
                break;
        }

        for (int i = 0; i < count; i++)
            System.out.println((i + 1) + ". " + students[i]);

        System.out.println("Sorted in " + passes + " passes");

        sc.close();
    }
}