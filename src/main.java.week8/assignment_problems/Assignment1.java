package main.java.week8.assignment_problems;

import java.util.Scanner;

public class Assignment1 {

    static abstract class Customer {
        protected double amount;

        Customer(double amount) {
            this.amount = amount;
        }

        abstract double finalAmount();

        abstract String getType();
    }

    static class Student extends Customer {
        Student(double amount) {
            super(amount);
        }

        double finalAmount() {
            return amount * 0.90;
        }

        String getType() {
            return "STUDENT";
        }
    }

    static class Staff extends Customer {
        Staff(double amount) {
            super(amount);
        }

        double finalAmount() {
            return amount * 0.95;
        }

        String getType() {
            return "STAFF";
        }
    }

    static class Guest extends Customer {
        Guest(double amount) {
            super(amount);
        }

        double finalAmount() {
            return amount + 10;
        }

        String getType() {
            return "GUEST";
        }
    }

    static Customer createCustomer(String type, double amount) {
        if (type.equals("STUDENT")) {
            return new Student(amount);
        } else if (type.equals("STAFF")) {
            return new Staff(amount);
        } else {
            return new Guest(amount);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer = createCustomer(type, amount);

            double finalAmount = customer.finalAmount();

            System.out.printf("%s: %.2f%n",
                    customer.getType(), finalAmount);

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}