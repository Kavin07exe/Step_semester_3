package week9.assigment_problems;

import java.util.Scanner;

abstract class LibraryItem {
    String title;
    int days;

    LibraryItem(String title, int days) {
        this.title = title;
        this.days = days;
    }

    abstract double fine();
}

class Book extends LibraryItem {
    Book(String t, int d) { super(t, d); }
    double fine() { return days * 2.0; }
}

class DVD extends LibraryItem {
    DVD(String t, int d) { super(t, d); }
    double fine() { return Math.min(days * 5.0, 50); }
}

class Magazine extends LibraryItem {
    Magazine(String t, int d) { super(t, d); }
    double fine() { return days * 1.0; }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();

            LibraryItem item = switch (type) {
                case "BOOK" -> new Book(title, days);
                case "DVD" -> new DVD(title, days);
                default -> new Magazine(title, days);
            };

            double fine = item.fine();
            System.out.printf("%s: %.2f%n", title, fine);
            total += fine;
        }

        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}