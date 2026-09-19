package main.java.week4.assignment_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Assignment4 {

    public static int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> prefixSumCount = new HashMap<>();

        // Sum 0 occurs once before starting the array
        prefixSumCount.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {

            prefixSum += num;

            // Check if a previous prefix gives sum k
            if (prefixSumCount.containsKey(prefixSum - k)) {
                count += prefixSumCount.get(prefixSum - k);
            }

            prefixSumCount.put(
                    prefixSum,
                    prefixSumCount.getOrDefault(prefixSum, 0) + 1
            );
        }

        return count;
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

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = subarraySum(nums, k);

        System.out.println("Number of subarrays with sum " + k + ": " + result);

        sc.close();
    }
}