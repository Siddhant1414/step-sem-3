package main.java.week9.practice_problems;

import java.util.Scanner;

public class Practice5 {

    static abstract class Booking {
        protected double distance;
        static final double BOOKING_FEE = 50;

        Booking(double distance) {
            this.distance = distance;
        }

        abstract double calculateFare();
        abstract String getType();

        double total() {
            return calculateFare() + BOOKING_FEE;
        }
    }

    static class Bus extends Booking {
        Bus(double distance) {
            super(distance);
        }

        double calculateFare() {
            return distance * 2;
        }

        String getType() {
            return "BUS";
        }
    }

    static class Train extends Booking {
        Train(double distance) {
            super(distance);
        }

        double calculateFare() {
            return distance * 1.5;
        }

        String getType() {
            return "TRAIN";
        }
    }

    static class Flight extends Booking {
        Flight(double distance) {
            super(distance);
        }

        double calculateFare() {
            return 2500 + distance * 4;
        }

        String getType() {
            return "FLIGHT";
        }
    }

    static Booking createBooking(String type, double distance) {
        if (type.equals("BUS"))
            return new Bus(distance);
        else if (type.equals("TRAIN"))
            return new Train(distance);
        else
            return new Flight(distance);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();

            Booking booking =
                    createBooking(type, distance);

            System.out.printf("%s: %.2f%n",
                    booking.getType(), booking.total());
        }

        sc.close();
    }
}