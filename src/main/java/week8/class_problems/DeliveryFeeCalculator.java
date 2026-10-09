package week8.class_problems;

import java.util.Scanner;

abstract class Delivery {
    double weight, distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double w, double d) {
        super(w, d);
    }

    double calculateFee() {
        return 5 + 0.5 * weight + 0.1 * distance;
    }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double w, double d) {
        super(w, d);
    }

    double calculateFee() {
        return 15 + weight + 0.2 * distance;
    }
}

class InternationalDelivery extends Delivery {
    double customsFee;

    InternationalDelivery(double w, double d, double c) {
        super(w, d);
        customsFee = c;
    }

    double calculateFee() {
        return 25 + 2 * weight + 0.5 * distance + customsFee;
    }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            Delivery d;

            switch (type) {
                case "STANDARD":
                    d = new StandardDelivery(weight, distance);
                    break;
                case "EXPRESS":
                    d = new ExpressDelivery(weight, distance);
                    break;
                default:
                    double customs = sc.nextDouble();
                    d = new InternationalDelivery(weight, distance, customs);
            }

            double fee = d.calculateFee();
            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}