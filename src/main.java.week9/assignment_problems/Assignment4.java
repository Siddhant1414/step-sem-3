package main.java.week9.assignment_problems;

import java.util.Scanner;

public class Assignment4 {

    static abstract class Cab {
        protected double km;

        Cab(double km) {
            this.km = km;
        }

        abstract double getRate();
        abstract String getType();
        abstract boolean offersNight();

        double calculateFare(boolean night) {
            double fare = Math.max(100, km * getRate());

            if (night) {
                fare = fare * 1.20;
            }

            return fare;
        }
    }

    static class Mini extends Cab {
        Mini(double km) {
            super(km);
        }

        double getRate() {
            return 10;
        }

        String getType() {
            return "MINI";
        }

        boolean offersNight() {
            return false;
        }
    }

    static class Sedan extends Cab {
        Sedan(double km) {
            super(km);
        }

        double getRate() {
            return 14;
        }

        String getType() {
            return "SEDAN";
        }

        boolean offersNight() {
            return true;
        }
    }

    static class SUV extends Cab {
        SUV(double km) {
            super(km);
        }

        double getRate() {
            return 18;
        }

        String getType() {
            return "SUV";
        }

        boolean offersNight() {
            return true;
        }
    }

    static Cab createCab(String type, double km) {
        if (type.equals("MINI"))
            return new Mini(km);
        else if (type.equals("SEDAN"))
            return new Sedan(km);
        else
            return new SUV(km);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab = createCab(type, km);

            boolean night = time.equals("NIGHT");

            if (night && !cab.offersNight()) {
                System.out.println(
                    cab.getType() + ": night service not available"
                );
            } else {
                double fare = cab.calculateFare(night);

                System.out.printf("%s: %.2f%n",
                        cab.getType(), fare);

                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}