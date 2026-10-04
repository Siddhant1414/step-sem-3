package main.java.week9.practice_problems;

import java.util.Scanner;

public class Practice4 {

    static abstract class Connection {
        protected double units;

        Connection(double units) {
            this.units = units;
        }

        abstract double calculateBill();
        abstract String getType();
    }

    static class Home extends Connection {
        Home(double units) {
            super(units);
        }

        double calculateBill() {
            if (units <= 100)
                return units * 5;
            return 100 * 5 + (units - 100) * 7;
        }

        String getType() {
            return "HOME";
        }
    }

    static class Shop extends Connection {
        Shop(double units) {
            super(units);
        }

        double calculateBill() {
            return units * 8 + 100;
        }

        String getType() {
            return "SHOP";
        }
    }

    static class Factory extends Connection {
        Factory(double units) {
            super(units);
        }

        double calculateBill() {
            return Math.max(units * 6, 1000);
        }

        String getType() {
            return "FACTORY";
        }
    }

    static Connection createConnection(String type, double units) {
        if (type.equals("HOME"))
            return new Home(units);
        else if (type.equals("SHOP"))
            return new Shop(units);
        else
            return new Factory(units);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double units = sc.nextDouble();

            Connection connection =
                    createConnection(type, units);

            double bill = connection.calculateBill();

            System.out.printf("%s: %.2f%n",
                    connection.getType(), bill);

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}