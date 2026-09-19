package main.java.week2.assignment_problems;

import java.util.Scanner;

public class Assignment4 {

    public static String normalizeISBN(String isbn) {

        return isbn.replace("-", "").replace(" ", "");
    }

    public static boolean validateISBN(String isbn) {

        if (isbn.length() == 10) {
            return true;
        }

        if (isbn.length() == 13) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        String normalizedISBN = normalizeISBN(isbn);

        System.out.println("Normalized ISBN: " + normalizedISBN);

        if (validateISBN(normalizedISBN)) {
            System.out.println("Valid ISBN format.");
        } else {
            System.out.println("Invalid ISBN format.");
        }

        sc.close();
    }
}