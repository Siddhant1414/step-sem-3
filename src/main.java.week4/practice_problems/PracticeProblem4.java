package main.java.week4.practice_problems;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeProblem4 {

    public static int[] mergeSortedArrays(int[] first, int[] second) {

        int[] result = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length) {

            if (first[i] <= second[j]) {
                result[k] = first[i];
                i++;
            } else {
                result[k] = second[j];
                j++;
            }

            k++;
        }

        while (i < first.length) {
            result[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            result[k] = second[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int n1 = sc.nextInt();

        int[] first = new int[n1];

        System.out.println("Enter first sorted array:");

        for (int i = 0; i < n1; i++) {
            first[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int n2 = sc.nextInt();

        int[] second = new int[n2];

        System.out.println("Enter second sorted array:");

        for (int i = 0; i < n2; i++) {
            second[i] = sc.nextInt();
        }

        int[] result = mergeSortedArrays(first, second);

        System.out.println("Merged array: " + Arrays.toString(result));

        sc.close();
    }
}