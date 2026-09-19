package main.java.week2.practice_problems;

import java.util.Scanner;

public class PracticeProblem2 {

    public static void parseStudentRecord(String record) {

        String[] details = record.split(",");

        System.out.println("Name: " + details[0]);
        System.out.println("Roll Number: " + details[1]);
        System.out.println("Department: " + details[2]);
        System.out.println("CGPA: " + details[3]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student record (Name,RollNo,Department,CGPA): ");
        String record = sc.nextLine();

        parseStudentRecord(record);

        sc.close();
    }
}