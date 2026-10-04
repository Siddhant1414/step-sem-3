package main.java.week8.assignment_problems;

import java.util.Scanner;

public class Assignment5 {

    static abstract class Plan {
        protected double fee;

        Plan(double fee) {
            this.fee = fee;
        }

        abstract double renewalFee();

        abstract String getType();
    }

    static class Basic extends Plan {
        Basic() {
            super(199);
        }

        double renewalFee() {
            return fee;
        }

        String getType() {
            return "BASIC";
        }
    }

    static class Standard extends Plan {
        Standard() {
            super(299);
        }

        double renewalFee() {
            return fee;
        }

        String getType() {
            return "STANDARD";
        }
    }

    static class Premium extends Plan {
        Premium() {
            super(499);
        }

        double renewalFee() {
            return fee;
        }

        String getType() {
            return "PREMIUM";
        }
    }

    static Plan createPlan(String type) {
        if (type.equals("BASIC")) {
            return new Basic();
        } else if (type.equals("STANDARD")) {
            return new Standard();
        } else {
            return new Premium();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int daysLate = sc.nextInt();

            Plan plan = createPlan(type);

            double amount = plan.renewalFee();

            if (daysLate > 0) {
                amount += daysLate * 10;
            }

            System.out.printf("%s: %.2f%n",
                    plan.getType(), amount);

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}