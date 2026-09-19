package main.java.week4.practice_problems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PracticeProblem3 {

    public static boolean containsDuplicate(int[] nums) {

        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {

            if (seen.contains(num)) {
                return true;
            }

            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        if (containsDuplicate(nums)) {
            System.out.println("Array contains duplicates.");
        } else {
            System.out.println("Array does not contain duplicates.");
        }

        sc.close();
    }
}