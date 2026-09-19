package main.java.week4.assignment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment1 {

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        // Forward pass
        int prefixProduct = 1;

        for (int i = 0; i < n; i++) {
            answer[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        // Backward pass
        int suffixProduct = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return answer;
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

        int[] result = productExceptSelf(nums);

        System.out.println("Result: " + Arrays.toString(result));

        sc.close();
    }
}