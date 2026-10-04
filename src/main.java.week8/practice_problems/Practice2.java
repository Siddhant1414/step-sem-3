package main.java.week8.practice_problems;

import java.util.Scanner;
import java.time.LocalDate;

public class Practice2 {

    static abstract class LibraryItem {
        protected String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int getDays();
        abstract String getType();
    }

    static class Book extends LibraryItem {
        Book(String title) {
            super(title);
        }

        int getDays() {
            return 14;
        }

        String getType() {
            return "BOOK";
        }
    }

    static class DVD extends LibraryItem {
        DVD(String title) {
            super(title);
        }

        int getDays() {
            return 7;
        }

        String getType() {
            return "DVD";
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) {
            super(title);
        }

        int getDays() {
            return 3;
        }

        String getType() {
            return "MAGAZINE";
        }
    }

    static LibraryItem createItem(String type, String title) {
        if (type.equals("BOOK"))
            return new Book(title);
        else if (type.equals("DVD"))
            return new DVD(title);
        else
            return new Magazine(title);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            int space = line.indexOf(' ');
            String type = line.substring(0, space);

            String title = line.substring(space + 1);
            title = title.replace("\"", "");

            LibraryItem item = createItem(type, title);

            LocalDate dueDate =
                    currentDate.plusDays(item.getDays());

            System.out.println(
                    item.title + ": " + dueDate
            );
        }

        sc.close();
    }
}