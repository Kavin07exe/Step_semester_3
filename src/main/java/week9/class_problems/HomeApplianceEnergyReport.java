package week9.class_problems;

import java.util.Scanner;

abstract class Appliance {
    double hours;
    Appliance(double h) { hours = h; }
    abstract double power();
    boolean supportsSaver() { return false; }
    double units() { return power() * hours / 1000; }
}

interface SaverMode {
    double saverUnits();
}

class Fridge extends Appliance {
    Fridge(double h) { super(h); }
    double power() { return 150; }
}

class AC extends Appliance implements SaverMode {
    AC(double h) { super(h); }
    double power() { return 1500; }
    public double saverUnits() { return units() * 0.75; }
    boolean supportsSaver() { return true; }
}

class TV extends Appliance {
    TV(double h) { super(h); }
    double power() { return 100; }
}

class Washer extends Appliance implements SaverMode {
    Washer(double h) { super(h); }
    double power() { return 500; }
    public double saverUnits() { return units() * 0.75; }
    boolean supportsSaver() { return true; }
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
            if (saver) sc.next();

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

            double units = saver
                    ? ((SaverMode) a).saverUnits()
                    : a.units();

            double cost = units * 8;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost);
            total += cost;
        }

        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}