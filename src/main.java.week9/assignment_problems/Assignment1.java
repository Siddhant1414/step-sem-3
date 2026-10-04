package main.java.week9.assignment_problems;

import java.util.Scanner;

public class Assignment1 {

    static final double CONVENIENCE_FEE = 20;

    static abstract class Ticket {
        protected int count;

        Ticket(int count) {
            this.count = count;
        }

        abstract double getPrice();
        abstract String getType();

        double calculateAmount() {
            return count * (getPrice() + CONVENIENCE_FEE);
        }
    }

    static class Regular extends Ticket {
        Regular(int count) {
            super(count);
        }

        double getPrice() {
            return 150;
        }

        String getType() {
            return "REGULAR";
        }
    }

    static class Premium extends Ticket {
        Premium(int count) {
            super(count);
        }

        double getPrice() {
            return 250;
        }

        String getType() {
            return "PREMIUM";
        }
    }

    static class Recliner extends Ticket {
        Recliner(int count) {
            super(count);
        }

        double getPrice() {
            return 400;
        }

        String getType() {
            return "RECLINER";
        }
    }

    static Ticket createTicket(String type, int count) {
        if (type.equals("REGULAR"))
            return new Regular(count);
        else if (type.equals("PREMIUM"))
            return new Premium(count);
        else
            return new Recliner(count);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int count = sc.nextInt();

            Ticket ticket = createTicket(type, count);

            double amount = ticket.calculateAmount();

            System.out.printf("%s: %.2f%n",
                    ticket.getType(), amount);

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}