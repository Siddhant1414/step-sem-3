package main.java.week5.practice_problems;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeProblem5 {

    static class Candidate implements Comparable<Candidate> {

        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        public static boolean isEligible(double cgpa) {
            return cgpa >= 8.0;
        }

        public static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        public double getCompositeScore() {
            return (cgpa * 10) + (codingScore * 0.5);
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(
                    other.getCompositeScore(),
                    this.getCompositeScore()
            );
        }
    }

    public static Candidate[] shortlistCandidates(Candidate[] candidates) {

        Candidate[] eligible = new Candidate[candidates.length];
        int count = 0;

        for (Candidate candidate : candidates) {

            if (Candidate.isEligible(candidate.cgpa)
                    || Candidate.isEligible(
                            candidate.cgpa,
                            candidate.codingScore)) {

                eligible[count] = candidate;
                count++;
            }
        }

        return Arrays.copyOf(eligible, count);
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

        Candidate[] eligible = shortlistCandidates(candidates);

        Arrays.sort(eligible);

        System.out.println("\nShortlisted Candidates:");

        for (int i = 0; i < eligible.length; i++) {

            System.out.println(
                    (i + 1) + ". "
                    + eligible[i].getName()
                    + " - Composite Score: "
                    + String.format(
                            "%.1f",
                            eligible[i].getCompositeScore()));
        }

        sc.close();
    }
}