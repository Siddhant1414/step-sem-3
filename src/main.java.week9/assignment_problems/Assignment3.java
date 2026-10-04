package main.java.week9.assignment_problems;

import java.util.Scanner;

public class Assignment3 {

    static abstract class Student {
        protected String name;

        Student(String name) {
            this.name = name;
        }

        abstract double calculateFee();
    }

    static class DayScholar extends Student {
        DayScholar(String name) {
            super(name);
        }

        double calculateFee() {
            return 40000 + 12000;
        }
    }

    static class Hosteller extends Student {
        Hosteller(String name) {
            super(name);
        }

        double calculateFee() {
            return 40000 + 60000;
        }
    }

    static class Scholar extends Student {
        Scholar(String name) {
            super(name);
        }

        double calculateFee() {
            return 20000 + 12000;
        }
    }

    static Student createStudent(String type, String name) {
        if (type.equals("DAY_SCHOLAR"))
            return new DayScholar(name);
        else if (type.equals("HOSTELLER"))
            return new Hosteller(name);
        else
            return new Scholar(name);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            Student student = createStudent(type, name);

            double fee = student.calculateFee();

            System.out.printf("%s: %.2f%n",
                    student.name, fee);

            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);

        sc.close();
    }
}