package main.java.week9.practice_problems;

import java.util.Scanner;

public class Practice1 {

    static abstract class Plot {
        protected String owner;

        Plot(String owner) {
            this.owner = owner;
        }

        abstract double area();
        abstract String getShape();
    }

    static class Circle extends Plot {
        private double radius;

        Circle(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        double area() {
            return Math.PI * radius * radius;
        }

        String getShape() {
            return "CIRCLE";
        }
    }

    static class Rectangle extends Plot {
        private double length;
        private double width;

        Rectangle(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        double area() {
            return length * width;
        }

        String getShape() {
            return "RECTANGLE";
        }
    }

    static class Triangle extends Plot {
        private double base;
        private double height;

        Triangle(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        double area() {
            return 0.5 * base * height;
        }

        String getShape() {
            return "TRIANGLE";
        }
    }

    static Plot createPlot(String shape, String owner, double a, double b) {

        if (shape.equals("CIRCLE"))
            return new Circle(owner, a);

        else if (shape.equals("RECTANGLE"))
            return new Rectangle(owner, a, b);

        else
            return new Triangle(owner, a, b);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String shape = sc.next();
            String owner = sc.next();

            double a = sc.nextDouble();
            double b = 0;

            if (!shape.equals("CIRCLE")) {
                b = sc.nextDouble();
            }

            Plot plot = createPlot(shape, owner, a, b);

            double area = plot.area();

            System.out.printf(
                "%s (%s): %.2f%n",
                owner, plot.getShape(), area
            );

            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);

        sc.close();
    }
}