package main.java.week6.practice_problems;

public class Practice4 {

    static class HallTicket {
        String hallTicketNumber;
        String studentName;
        String department;
        String examRoom;

        public HallTicket(String hallTicketNumber, String studentName,
                           String department, String examRoom) {
            this.hallTicketNumber = hallTicketNumber;
            this.studentName = studentName;
            this.department = department;
            this.examRoom = examRoom;
        }

        public void printTicket() {
            System.out.println(
                hallTicketNumber + " | " +
                studentName + " | " +
                department + " | " +
                examRoom
            );
        }
    }

    public static void main(String[] args) {

        HallTicket student1 = new HallTicket(
            "HT-101", "Siddhant", "CSBS", "Room A"
        );

        HallTicket student2 = new HallTicket(
            "HT-102", "Rahul", "CSE", "Room B"
        );

        student1.printTicket();
        student2.printTicket();
    }
}