package week9.assigment_problems;

import java.util.Scanner;

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double rate();

    double fare() {
        return Math.max(100, km * rate());
    }
}

interface NightService {
    double nightFare(double fare);
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double rate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double rate() {
        return 14;
    }

    public double nightFare(double fare) {
        return fare * 1.2;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double rate() {
        return 18;
    }

    public double nightFare(double fare) {
        return fare * 1.2;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab = switch (type) {
                case "MINI" -> new Mini(km);
                case "SEDAN" -> new Sedan(km);
                default -> new SUV(km);
            };

            if (time.equals("NIGHT")) {
                if (!(cab instanceof NightService)) {
                    System.out.println(type + ": night service not available");
                    continue;
                }

                cabFare = ((NightService) cab).nightFare(cab.fare());
            } else {
                cabFare = cab.fare();
            }

            System.out.printf("%s: %.2f%n", type, cabFare);
            total += cabFare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}