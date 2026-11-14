package week12.assignment_problems;

import java.util.Scanner;

public class BookCopyFinder {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static void find(Node head, String id) {
        int position = 1, first = -1, copies = 0;

        while (head != null) {
            if (head.data.equals(id)) {
                if (first == -1)
                    first = position;
                copies++;
            }

            head = head.next;
            position++;
        }

        if (first == -1)
            System.out.println(id + " not found");
        else
            System.out.println(id + " first at position "
                    + first + ", copies: " + copies);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node head = null, tail = null;

        for (int i = 0; i < n; i++) {
            Node node = new Node(sc.next());

            if (head == null)
                head = node;
            else
                tail.next = node;

            tail = node;
        }

        String id = sc.next();
        find(head, id);

        sc.close();
    }
}