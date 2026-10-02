package main.java.week5.practice_problems;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeProblem3 {

    public static int[] findTopThree(int[] scores) {

        int[] topThree = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int score : scores) {

            if (score > topThree[0]) {
                topThree[2] = topThree[1];
                topThree[1] = topThree[0];
                topThree[0] = score;

            } else if (score > topThree[1]) {
                topThree[2] = topThree[1];
                topThree[1] = score;

            } else if (score > topThree[2]) {
                topThree[2] = score;
            }
        }

        return topThree;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of participants: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter scores:");

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        if (n < 3) {
            System.out.println("At least 3 scores are required.");
        } else {
            int[] result = findTopThree(scores);

            System.out.println("Top 3 scores: "
                    + Arrays.toString(result));
        }

        sc.close();
    }
}