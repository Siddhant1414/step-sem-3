package main.java.week2.assignment_problems;

import java.util.Scanner;

public class Assignment3 {

    public static void parseProduct(String product) {

        String[] details = product.split(",");

        System.out.println("Product ID: " + details[0]);
        System.out.println("Product Name: " + details[1]);
        System.out.println("Price: " + details[2]);
        System.out.println("Quantity: " + details[3]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product details (ID,Name,Price,Quantity): ");
        String product = sc.nextLine();

        parseProduct(product);

        sc.close();
    }
}