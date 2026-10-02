package main.java.week5.practice_problems;

import java.util.Scanner;

public class PracticeProblem4 {

    public static void printRowMaximums(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {

            int max = grid[i][0];

            for (int j = 1; j < grid[i].length; j++) {

                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }

            System.out.println("Row " + (i + 1)
                    + " maximum: " + max);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = sc.nextInt();

        int[][] grid = new int[rows][columns];

        System.out.println("Enter grid values:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        printRowMaximums(grid);

        sc.close();
    }
}