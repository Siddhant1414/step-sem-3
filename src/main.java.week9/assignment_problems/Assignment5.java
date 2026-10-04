package main.java.week9.assignment_problems;

import java.util.Scanner;

public class Assignment5 {

    static abstract class Appliance {
        protected double hours;

        Appliance(double hours) {
            this.hours = hours;
        }

        abstract double getPower();
        abstract String getType();
        abstract boolean supportsSaver();

        double calculateUnits(boolean saver) {
            double units = getPower() * hours / 1000;

            if (saver) {
                units *= 0.75;
            }

            return units;
        }

        double calculateCost(boolean saver) {
            return calculateUnits(saver) * 8;
        }
    }

    static class Fridge extends Appliance {
        Fridge(double hours) {
            super(hours);
        }

        double getPower() {
            return 150;
        }

        String getType() {
            return "FRIDGE";
        }

        boolean supportsSaver() {
            return false;
        }
    }

    static class AC extends Appliance {
        AC(double hours) {
            super(hours);
        }

        double getPower() {
            return 1500;
        }

        String getType() {
            return "AC";
        }

        boolean supportsSaver() {
            return true;
        }
    }

    static class TV extends Appliance {
        TV(double hours) {
            super(hours);
        }

        double getPower() {
            return 100;
        }

        String getType() {
            return "TV";
        }

        boolean supportsSaver() {
            return false;
        }
    }

    static class Washer extends Appliance {
        Washer(double hours) {
            super(hours);
        }

        double getPower() {
            return 500;
        }

        String getType() {
            return "WASHER";
        }

        boolean supportsSaver() {
            return true;
        }
    }

    static Appliance createAppliance(String type, double hours) {
        if (type.equals("FRIDGE"))
            return new Fridge(hours);
        else if (type.equals("AC"))
            return new AC(hours);
        else if (type.equals("TV"))
            return new TV(hours);
        else
            return new Washer(hours);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();
            String[] parts = line.split(" ");

            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);

            boolean saver = parts.length == 3 &&
                            parts[2].equals("SAVER");

            Appliance appliance = createAppliance(type, hours);

            if (saver && !appliance.supportsSaver()) {

                System.out.println(
                    appliance.getType()
                    + ": saver mode not supported"
                );

            } else {

                double units = appliance.calculateUnits(saver);
                double cost = appliance.calculateCost(saver);

                System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    appliance.getType(), units, cost
                );

                totalCost += cost;
            }
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}