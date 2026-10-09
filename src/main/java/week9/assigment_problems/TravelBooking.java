package week9.assigment_problems;

import java.util.Scanner;

abstract class Travel {
    static final double FEE = 50;
    double distance;

    Travel(double d) {
        distance = d;
    }

    abstract double fare();

    double total() {
        return fare() + FEE;
    }
}

class Bus extends Travel {
    Bus(double d) { super(d); }
    double fare() { return distance * 2; }
}

class Train extends Travel {
    Train(double d) { super(d); }
    double fare() { return distance * 1.5; }
}

class Flight extends Travel {
    Flight(double d) { super(d); }
    double fare() { return 2500 + distance * 4; }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            Travel t = switch (mode) {
                case "BUS" -> new Bus(distance);
                case "TRAIN" -> new Train(distance);
                default -> new Flight(distance);
            };

            System.out.printf("%s: %.2f%n", mode, t.total());
        }

        sc.close();
    }
}