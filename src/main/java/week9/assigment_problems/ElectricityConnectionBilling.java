package week9.assigment_problems;

import java.util.Scanner;

abstract class Connection {
    int units;

    Connection(int units) {
        this.units = units;
    }

    abstract double bill();
}

class Home extends Connection {
    Home(int u) { super(u); }

    double bill() {
        return Math.min(units, 100) * 5.0
                + Math.max(0, units - 100) * 7.0;
    }
}

class Shop extends Connection {
    Shop(int u) { super(u); }

    double bill() {
        return units * 8.0 + 100;
    }
}

class Factory extends Connection {
    Factory(int u) { super(u); }

    double bill() {
        return Math.max(1000, units * 6.0);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            Connection c = switch (type) {
                case "HOME" -> new Home(units);
                case "SHOP" -> new Shop(units);
                default -> new Factory(units);
            };

            double bill = c.bill();
            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}