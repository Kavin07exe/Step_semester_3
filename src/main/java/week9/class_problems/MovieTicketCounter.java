package week9.class_problems;

import java.util.Scanner;

abstract class Ticket {
    static final int FEE = 20;
    int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract int price();

    double amount() {
        return (price() + FEE) * count;
    }
}

class Regular extends Ticket {
    Regular(int n) { super(n); }
    int price() { return 150; }
}

class Premium extends Ticket {
    Premium(int n) { super(n); }
    int price() { return 250; }
}

class Recliner extends Ticket {
    Recliner(int n) { super(n); }
    int price() { return 400; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            Ticket t = switch (seat) {
                case "REGULAR" -> new Regular(count);
                case "PREMIUM" -> new Premium(count);
                default -> new Recliner(count);
            };

            double amount = t.amount();
            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}