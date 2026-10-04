package main.java.week8.assignment_problems;

import java.util.Scanner;

public class Assignment3 {

    static abstract class Room {
        protected int units;

        Room(int units) {
            this.units = units;
        }

        abstract double calculateBill();

        abstract String getType();
    }

    static class SingleRoom extends Room {
        SingleRoom(int units) {
            super(units);
        }

        double calculateBill() {
            return units * 8.0;
        }

        String getType() {
            return "SINGLE";
        }
    }

    static class SharedRoom extends Room {
        private int occupants;

        SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        double calculateBill() {
            return (units * 6.0) / occupants;
        }

        String getType() {
            return "SHARED";
        }
    }

    static class ACRoom extends Room {
        ACRoom(int units) {
            super(units);
        }

        double calculateBill() {
            return units * 10.0 + 200;
        }

        String getType() {
            return "AC";
        }
    }

    static Room createRoom(String type, int units, int occupants) {
        if (type.equals("SINGLE")) {
            return new SingleRoom(units);
        } else if (type.equals("SHARED")) {
            return new SharedRoom(units, occupants);
        } else {
            return new ACRoom(units);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            int occupants = 0;

            if (type.equals("SHARED")) {
                occupants = sc.nextInt();
            }

            Room room = createRoom(type, units, occupants);

            double bill = room.calculateBill();

            System.out.printf("%s: %.2f%n",
                    room.getType(), bill);

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}