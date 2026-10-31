package week9.assigment_problems;

import java.util.Scanner;

abstract class Appliance {
    double hours;
    static final double COST = 8;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double power();

    double units() {
        return power() * hours / 1000;
    }

    double cost() {
        return units() * COST;
    }
}

interface SaverMode {
    double savings(double units);
}

class Fridge extends Appliance {
    Fridge(double h) {
        super(h);
    }

    double power() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double h) {
        super(h);
    }

    double power() {
        return 1500;
    }

    public double savings(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {
    TV(double h) {
        super(h);
    }

    double power() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double h) {
        super(h);
    }

    double power() {
        return 500;
    }

    public double savings(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = sc.hasNext("SAVER");
            if (saver) {
                sc.next();
            }

            Appliance a = switch (type) {
                case "FRIDGE" -> new Fridge(hours);
                case "AC" -> new AC(hours);
                case "TV" -> new TV(hours);
                default -> new Washer(hours);
            };

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = a.units();

            if (saver) {
                units = ((SaverMode) a).savings(units);
            }

            double cost = units * Appliance.COST;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            total += cost;
        }

        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}