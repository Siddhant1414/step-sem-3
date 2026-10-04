package main.java.week8.practice_problems;

import java.util.Scanner;

public class Practice3 {

    static abstract class Delivery {
        protected double weight, distance;

        Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        abstract double calculateFee();
        abstract String getType();
    }

    static class Standard extends Delivery {
        Standard(double weight, double distance) {
            super(weight, distance);
        }

        double calculateFee() {
            return 5 + (weight * 0.50) + (distance * 0.10);
        }

        String getType() {
            return "STANDARD";
        }
    }

    static class Express extends Delivery {
        Express(double weight, double distance) {
            super(weight, distance);
        }

        double calculateFee() {
            return 15 + (weight * 1.00) + (distance * 0.20);
        }

        String getType() {
            return "EXPRESS";
        }
    }

    static class International extends Delivery {
        private double customsFee;

        International(double weight, double distance, double customsFee) {
            super(weight, distance);
            this.customsFee = customsFee;
        }

        double calculateFee() {
            return 25 + (weight * 2.00)
                    + (distance * 0.50) + customsFee;
        }

        String getType() {
            return "INTERNATIONAL";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            Delivery delivery;

            if (type.equals("STANDARD")) {
                delivery = new Standard(weight, distance);
            } 
            else if (type.equals("EXPRESS")) {
                delivery = new Express(weight, distance);
            } 
            else {
                double customsFee = sc.nextDouble();
                delivery = new International(
                        weight, distance, customsFee);
            }

            double fee = delivery.calculateFee();

            System.out.printf("%s: %.2f%n",
                    delivery.getType(), fee);

            total += fee;
        }

        System.out.printf("%nTotal: %.2f%n", total);

        sc.close();
    }
}