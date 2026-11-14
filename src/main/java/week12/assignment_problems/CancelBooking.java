package week12.assignment_problems;

import java.util.Scanner;

public class CancelBooking {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node removeFirst(Node head, String booking) {
        if (head == null)
            return null;

        if (head.data.equals(booking))
            return head.next;

        Node current = head;

        while (current.next != null) {
            if (current.next.data.equals(booking)) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }

        System.out.println(booking + " not found");
        return head;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
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

        String booking = sc.next();
        head = removeFirst(head, booking);

        print(head);
        sc.close();
    }
}