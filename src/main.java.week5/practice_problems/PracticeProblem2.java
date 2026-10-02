package main.java.week5.practice_problems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PracticeProblem2 {

    public static boolean hasDuplicateNames(String[] teamNames) {

        Set<String> seen = new HashSet<>();

        for (String name : teamNames) {

            if (seen.contains(name)) {
                return true;
            }

            seen.add(name);
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of teams: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] teamNames = new String[n];

        System.out.println("Enter team names:");

        for (int i = 0; i < n; i++) {
            teamNames[i] = sc.nextLine();
        }

        if (hasDuplicateNames(teamNames)) {
            System.out.println("Duplicate team name found.");
        } else {
            System.out.println("No duplicate team names found.");
        }

        sc.close();
    }
}