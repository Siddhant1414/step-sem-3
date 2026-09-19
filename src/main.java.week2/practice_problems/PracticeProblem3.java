package main.java.week2.practice_problems;

import java.util.Scanner;

public class PracticeProblem3 {

    public static boolean isValidExtension(String fileName) {

        int dotIndex = fileName.lastIndexOf('.');

        if (dotIndex == -1 || dotIndex == fileName.length() - 1) {
            return false;
        }

        String extension = fileName.substring(dotIndex + 1).toLowerCase();

        return extension.equals("pdf")
                || extension.equals("jpg")
                || extension.equals("png")
                || extension.equals("txt");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        if (isValidExtension(fileName)) {
            System.out.println("Valid file extension.");
        } else {
            System.out.println("Invalid file extension.");
        }

        sc.close();
    }
}