package main.java.week2.assignment_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Assignment5 {

    public static Map<String, Integer> getWordFrequency(
            String text, Set<String> stopWords) {

        Map<String, Integer> frequency = new HashMap<>();

        String[] words = text.toLowerCase().split("\\s+");

        for (String word : words) {

            word = word.replaceAll("[^a-zA-Z]", "");

            if (word.isEmpty() || stopWords.contains(word)) {
                continue;
            }

            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        return frequency;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        Set<String> stopWords = new HashSet<>();

        System.out.print("Enter stop words separated by spaces: ");
        String stopWordInput = sc.nextLine();

        String[] stopWordArray = stopWordInput.toLowerCase().split("\\s+");

        for (String word : stopWordArray) {
            stopWords.add(word);
        }

        Map<String, Integer> frequency =
                getWordFrequency(text, stopWords);

        System.out.println();
        System.out.println("Word Frequency Report");
        System.out.println("---------------------");

        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        sc.close();
    }
}