package main.java.week2.practice_problems;

import java.util.Scanner;

public class PracticeProblem5 {

    public static String generateReference(String transactionType, int transactionId) {

        return transactionType.toUpperCase() + "-" + transactionId;
    }

    public static boolean validateReference(String reference) {

        int dashIndex = reference.indexOf('-');

        if (dashIndex <= 0 || dashIndex == reference.length() - 1) {
            return false;
        }

        String type = reference.substring(0, dashIndex);
        String id = reference.substring(dashIndex + 1);

        if (!type.matches("[A-Z]+")) {
            return false;
        }

        return id.matches("\\d+");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction type: ");
        String transactionType = sc.nextLine();

        System.out.print("Enter transaction ID: ");
        int transactionId = sc.nextInt();

        String reference = generateReference(transactionType, transactionId);

        System.out.println("Generated Reference: " + reference);

        if (validateReference(reference)) {
            System.out.println("Reference is valid.");
        } else {
            System.out.println("Reference is invalid.");
        }

        sc.close();
    }
}