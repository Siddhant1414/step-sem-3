package main.java.week6.assignment_problems;

public class Assignment5 {

    static class Employee {
        String empName;
        double salary;

        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {

        Employee employee1 = new Employee("Siddhant", 50000);
        Employee employee2 = new Employee("Rahul", 60000);
        Employee employee3 = new Employee("Aman", 55000);

        Employee.printCompanyInfo();
    }
}