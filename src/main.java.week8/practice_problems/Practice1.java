package main.java.week8.practice_problems;

import java.util.Scanner;

public class Practice1 {

    static abstract class Payment {
        protected double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        abstract double finalAmount();
        abstract String getType();
    }

    static class Card extends Payment {
        Card(double amount) {
            super(amount);
        }

        double finalAmount() {
            return amount * 1.02;
        }

        String getType() {
            return "CARD";
        }
    }

    static class Wallet extends Payment {
        Wallet(double amount) {
            super(amount);
        }

        double finalAmount() {
            return amount * 1.01;
        }

        String getType() {
            return "WALLET";
        }
    }

    static class BankTransfer extends Payment {
        BankTransfer(double amount) {
            super(amount);
        }

        double finalAmount() {
            return amount;
        }

        String getType() {
            return "BANKTRANSFER";
        }
    }

    static Payment createPayment(String type, double amount) {
        if (type.equals("CARD"))
            return new Card(amount);
        else if (type.equals("WALLET"))
            return new Wallet(amount);
        else
            return new BankTransfer(amount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Payment payment = createPayment(type, amount);
            double finalAmount = payment.finalAmount();

            System.out.printf("%s: %.2f%n",
                    payment.getType(), finalAmount);

            total += finalAmount;
        }

        System.out.printf("%nTotal: %.2f%n", total);

        sc.close();
    }
}