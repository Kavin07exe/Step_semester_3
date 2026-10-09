package week9.class_problems;

import java.util.Scanner;

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double tuition();

    boolean usesBus() {
        return true;
    }

    double fee() {
        return tuition() + (usesBus() ? 12000 : 0);
    }
}

class DayScholar extends Student {
    DayScholar(String n) { super(n); }
    double tuition() { return 40000; }
}

class Hosteller extends Student {
    Hosteller(String n) { super(n); }
    double tuition() { return 100000; }
    boolean usesBus() { return false; }
}

class Scholar extends Student {
    Scholar(String n) { super(n); }
    double tuition() { return 20000; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student s = switch (type) {
                case "DAY_SCHOLAR" -> new DayScholar(name);
                case "HOSTELLER" -> new Hosteller(name);
                default -> new Scholar(name);
            };

            double fee = s.fee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}