package main.java.week8.practice_problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice4 {

    static abstract class Question {
        protected String question;
        protected String correct;
        protected String student;
        protected double points;

        Question(String question, String correct,
                 String student, double points) {
            this.question = question;
            this.correct = correct;
            this.student = student;
            this.points = points;
        }

        abstract double score();
        abstract String getType();
    }

    static class MCQ extends Question {
        MCQ(String q, String c, String s, double p) {
            super(q, c, s, p);
        }

        double score() {
            return student.equalsIgnoreCase(correct) ? points : 0;
        }

        String getType() {
            return "MCQ";
        }
    }

    static class TF extends Question {
        TF(String q, String c, String s, double p) {
            super(q, c, s, p);
        }

        double score() {
            return student.equalsIgnoreCase(correct) ? points : 0;
        }

        String getType() {
            return "TF";
        }
    }

    static class Essay extends Question {
        Essay(String q, String c, String s, double p) {
            super(q, c, s, p);
        }

        double score() {
            String[] keywords = correct.split(",");
            int count = 0;

            for (String keyword : keywords) {
                if (student.toLowerCase()
                        .contains(keyword.trim().toLowerCase())) {
                    count++;
                }
            }

            if (count >= 2)
                return points * 0.75;
            else if (count == 1)
                return points * 0.50;
            else
                return 0;
        }

        String getType() {
            return "ESSAY";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        Pattern pattern = Pattern.compile(
            "^(\\S+)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+(?:\\.\\d+)?)$"
        );

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            Matcher matcher = pattern.matcher(line);

            if (matcher.matches()) {

                String type = matcher.group(1);
                String question = matcher.group(2);
                String correct = matcher.group(3);
                String student = matcher.group(4);
                double points = Double.parseDouble(matcher.group(5));

                Question q;

                if (type.equals("MCQ")) {
                    q = new MCQ(question, correct, student, points);
                }
                else if (type.equals("TF")) {
                    q = new TF(question, correct, student, points);
                }
                else {
                    q = new Essay(question, correct, student, points);
                }

                double score = q.score();

                System.out.printf("%s: %.2f%n",
                        q.getType(), score);

                total += score;
            }
        }

        System.out.printf("%nTotal Score: %.2f%n", total);

        sc.close();
    }
}