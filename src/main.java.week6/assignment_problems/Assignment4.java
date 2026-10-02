package main.java.week6.assignment_problems;

public class Assignment4 {

    static class HallTicket {

        String hallTicketNumber;
        String studentName;
        String department;

        HallTicket(String hallTicketNumber, String studentName,
                   String department) {
            this.hallTicketNumber = hallTicketNumber;
            this.studentName = studentName;
            this.department = department;
        }

        void printDetails() {
            System.out.println("Hall Ticket Number: " + hallTicketNumber);
            System.out.println("Student Name: " + studentName);
            System.out.println("Department: " + department);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        HallTicket student1 = new HallTicket(
                "HT101", "Siddhant", "CSBS");

        HallTicket student2 = new HallTicket(
                "HT102", "Rahul", "CSE");

        student1.printDetails();
        student2.printDetails();
    }
}