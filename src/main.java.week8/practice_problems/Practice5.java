package main.java.week8.practice_problems;

import java.util.Scanner;

public class Practice5 {

    static abstract class Transport {
        protected double distance;

        Transport(double distance) {
            this.distance = distance;
        }

        abstract double calculateFare();
        abstract String getType();
    }

    static class Bus extends Transport {
        Bus(double distance) {
            super(distance);
        }

        double calculateFare() {
            return Math.min(2 + distance * 0.10, 10);
        }

        String getType() {
            return "BUS";
        }
    }

    static class Train extends Transport {
        Train(double distance) {
            super(distance);
        }

        double calculateFare() {
            return 3 + distance * 0.15;
        }

        String getType() {
            return "TRAIN";
        }
    }

    static class Metro extends Transport {
        private double peakHourFactor;

        Metro(double distance, double peakHourFactor) {
            super(distance);
            this.peakHourFactor = peakHourFactor;
        }

        double calculateFare() {
            return (1.5 + distance * 0.20) * peakHourFactor;
        }

        String getType() {
            return "METRO";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();

            Transport transport;

            if (type.equals("BUS")) {
                transport = new Bus(distance);
            }
            else if (type.equals("TRAIN")) {
                transport = new Train(distance);
            }
            else {
                double peakHourFactor = sc.nextDouble();
                transport = new Metro(distance, peakHourFactor);
            }

            double fare = transport.calculateFare();

            System.out.printf("%s: %.2f%n",
                    transport.getType(), fare);

            total += fare;
        }

        System.out.printf("%nTotal: %.2f%n", total);

        sc.close();
    }
}