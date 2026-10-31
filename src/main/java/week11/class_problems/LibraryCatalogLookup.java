package week11.class_problems;

import java.util.Scanner;

class Book {
    String isbn, title;

    Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }
}

public class LibraryCatalogLookup {

    static String findBook(Book[] catalog, String target) {
        int left = 0, right = catalog.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = catalog[mid].isbn.compareTo(target);

            if (cmp == 0)
                return catalog[mid].title;
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Book[] catalog = new Book[n];

        for (int i = 0; i < n; i++) {
            String isbn = sc.nextLine();
            String title = sc.nextLine();
            catalog[i] = new Book(isbn, title);
        }

        String target = sc.nextLine();
        System.out.println(findBook(catalog, target));

        sc.close();
    }
}