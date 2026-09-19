package main.java.week2.assignment_problems;

import java.util.Scanner;

public class Assignment2 {

    public static String reverseWord(String word) {

        StringBuilder reversed = new StringBuilder(word);

        return reversed.reverse().toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = sc.nextLine();

        System.out.println("Reversed word: " + reverseWord(word));

        sc.close();
    }
}