package main.java.week5.assignment_problems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Assignment2 {

    public static boolean hasDuplicatePlayers(int[] playerIds) {

        Set<Integer> seen = new HashSet<>();

        for (int id : playerIds) {

            if (seen.contains(id)) {
                return true;
            }

            seen.add(id);
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        int[] playerIds = new int[n];

        System.out.println("Enter player IDs:");

        for (int i = 0; i < n; i++) {
            playerIds[i] = sc.nextInt();
        }

        boolean result = hasDuplicatePlayers(playerIds);

        System.out.println("Duplicate players found: " + result);

        sc.close();
    }
}