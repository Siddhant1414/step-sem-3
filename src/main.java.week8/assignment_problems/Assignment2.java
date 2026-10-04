package main.java.week8.assignment_problems;

import java.util.Scanner;

public class Assignment2 {

    static abstract class Vehicle {
        protected int hours;

        Vehicle(int hours) {
            this.hours = hours;
        }

        abstract double calculateCharge();

        abstract String getType();
    }

    static class Bike extends Vehicle {
        Bike(int hours) {
            super(hours);
        }

        double calculateCharge() {
            return hours * 10.0;
        }

        String getType() {
            return "BIKE";
        }
    }

    static class Car extends Vehicle {
        Car(int hours) {
            super(hours);
        }

        double calculateCharge() {
            return 30 + (hours - 1) * 20.0;
        }

        String getType() {
            return "CAR";
        }
    }

    static class Truck extends Vehicle {
        Truck(int hours) {
            super(hours);
        }

        double calculateCharge() {
            return Math.max(100, hours * 50.0);
        }

        String getType() {
            return "TRUCK";
        }
    }

    static Vehicle createVehicle(String type, int hours) {
        if (type.equals("BIKE")) {
            return new Bike(hours);
        } else if (type.equals("CAR")) {
            return new Car(hours);
        } else {
            return new Truck(hours);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle = createVehicle(type, hours);
            double charge = vehicle.calculateCharge();

            System.out.printf("%s: %.2f%n",
                    vehicle.getType(), charge);

            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}