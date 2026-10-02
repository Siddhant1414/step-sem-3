package main.java.week5.assignment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment3 {

    public static double[] getTopThree(double[] scores) {

        double[] topThree = new double[3];

        for (double score : scores) {

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

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        double[] scores = new double[n];

        System.out.println("Enter player scores:");

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
        }

        if (n < 3) {
            System.out.println("At least 3 scores are required.");
        } else {
            double[] result = getTopThree(scores);

            System.out.println("Top 3 scores: "
                    + Arrays.toString(result));
        }

        sc.close();
    }
}