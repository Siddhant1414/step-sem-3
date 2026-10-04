package main.java.week8.assignment_problems;

import java.util.Scanner;

public class Assignment4 {

    static abstract class Employee {
        protected String name;
        protected double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        abstract double calculateBonus();
    }

    static class FullTime extends Employee {
        FullTime(String name, double salary) {
            super(name, salary);
        }

        double calculateBonus() {
            return salary * 0.10;
        }
    }

    static class PartTime extends Employee {
        PartTime(String name, double salary) {
            super(name, salary);
        }

        double calculateBonus() {
            return salary * 0.05;
        }
    }

    static class Intern extends Employee {
        Intern(String name, double salary) {
            super(name, salary);
        }

        double calculateBonus() {
            return 2000;
        }
    }

    static Employee createEmployee(String type, String name, double salary) {
        if (type.equals("FULLTIME")) {
            return new FullTime(name, salary);
        } else if (type.equals("PARTTIME")) {
            return new PartTime(name, salary);
        } else {
            return new Intern(name, salary);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalBonus = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee = createEmployee(type, name, salary);

            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n", name, bonus);

            totalBonus += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);

        sc.close();
    }
}