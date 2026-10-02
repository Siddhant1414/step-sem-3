package main.java.week6.assignment_problems;

public class Assignment3 {

    static class Employee {

        int id;
        String name;
        double salary;

        Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        void printDetails() {
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Salary: " + salary);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Employee employee1 =
                new Employee(101, "Siddhant", 50000);

        Employee employee2 =
                new Employee(102, "Rahul", 60000);

        employee1.printDetails();
        employee2.printDetails();
    }
}