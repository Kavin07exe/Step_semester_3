package week8.assigment_problems;

import java.util.Scanner;
import java.time.LocalDate;

abstract class Plan {
    String name;
    LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int validity();

    LocalDate renewalDate() {
        return startDate.plusDays(validity());
    }
}

class Basic extends Plan {
    Basic(String n, LocalDate d) {
        super(n, d);
    }

    int validity() {
        return 30;
    }
}

class Standard extends Plan {
    Standard(String n, LocalDate d) {
        super(n, d);
    }

    int validity() {
        return 90;
    }
}

class Premium extends Plan {
    Premium(String n, LocalDate d) {
        super(n, d);
    }

    int validity() {
        return 365;
    }
}

public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());
            Plan p;

            switch (type) {
                case "BASIC":
                    p = new Basic(name, date);
                    break;
                case "STANDARD":
                    p = new Standard(name, date);
                    break;
                default:
                    p = new Premium(name, date);
            }

            System.out.println(name + ": " + p.renewalDate());
        }

        sc.close();
    }
}