package main.java.week4.practice_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PracticeProblem1 {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
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

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int[] result = twoSum(nums, target);

        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");

        sc.close();
    }
}