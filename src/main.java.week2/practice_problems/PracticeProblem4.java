package main.java.week2.practice_problems;

import java.util.Scanner;

public class PracticeProblem4 {

    public static String maskPhoneNumber(String phoneNumber) {

        if (phoneNumber.length() < 4) {
            return "Invalid phone number";
        }

        int visibleDigits = 4;
        int maskLength = phoneNumber.length() - visibleDigits;

        String masked = "";

        for (int i = 0; i < maskLength; i++) {
            masked += "*";
        }

        return masked + phoneNumber.substring(maskLength);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();

        System.out.println("Masked phone number: "
                + maskPhoneNumber(phoneNumber));

        sc.close();
    }
}