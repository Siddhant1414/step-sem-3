package main.java.week1.assignment_problems;

public class Assignment3 {

    public static void findLongestStreak(String signalLog) {

        char longestChar = signalLog.charAt(0);

        int currentCount = 1;
        int longestCount = 1;

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentCount++;
            } else {
                currentCount = 1;
            }

            if (currentCount > longestCount) {
                longestCount = currentCount;
                longestChar = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + longestChar
                + "' repeated " + longestCount + " times");
    }

    public static void main(String[] args) {

        String signalLog = "RRGGGYRR";

        findLongestStreak(signalLog);
    }
}