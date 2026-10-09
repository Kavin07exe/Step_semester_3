package week8.class_problems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    String title;
    int days;

    LibraryItem(String title, int days) {
        this.title = title;
        this.days = days;
    }

    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(days);
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title, 14);
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title, 7);
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title, 3);
    }
}

public class LibraryDueDateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).replace("\"", "");
            
            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book(title);
                    break;
                case "DVD":
                    item = new DVD(title);
                    break;
                default:
                    item = new Magazine(title);
            }

            System.out.println(title + ": " + item.getDueDate());
        }
        sc.close();
    }
}