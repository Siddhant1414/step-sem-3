package main.java.week5.assignment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment5 {

    static class Candidate implements Comparable<Candidate> {

        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        // CGPA-only eligibility
        public static boolean isDraftable(double cgpa) {
            return cgpa >= 8.0;
        }

        // Combined CGPA + coding score eligibility
        public static boolean isDraftable(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        public double getCompositeScore() {
            return (cgpa * 10) + (codingScore * 0.5);
        }

        @Override
        public int compareTo(Candidate other) {

            return Double.compare(
                    other.getCompositeScore(),
                    this.getCompositeScore()
            );
        }

        public String getName() {
            return name;
        }
    }

    public static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlist = new Candidate[candidates.length];
        int count = 0;

        for (Candidate candidate : candidates) {

            if (Candidate.isDraftable(candidate.cgpa)
                    || Candidate.isDraftable(
                            candidate.cgpa,
                            candidate.codingScore)) {

                shortlist[count] = candidate;
                count++;
            }
        }

        Candidate[] result = Arrays.copyOf(shortlist, count);

        Arrays.sort(result);

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < result.length; i++) {

            output.append(i + 1)
                  .append(". ")
                  .append(result[i].getName())
                  .append(" (")
                  .append(String.format("%.1f",
                          result[i].getCompositeScore()))
                  .append(")");

            if (i < result.length - 1) {
                output.append(" | ");
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nCandidate " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Coding Score: ");
            int codingScore = sc.nextInt();
            sc.nextLine();

            candidates[i] =
                    new Candidate(name, cgpa, codingScore);
        }

        System.out.println("\nShortlisted Candidates:");

        System.out.println(
                shortlistAndRank(candidates));

        sc.close();
    }
}