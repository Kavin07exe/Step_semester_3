package week12.assignment_problems;

import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class BusRouteStops {

    static Node build(String[] stops) {
        Node head = new Node(stops[0]);
        Node current = head;

        for (int i = 1; i < stops.length; i++) {
            current.next = new Node(stops[i]);
            current = current.next;
        }

        return head;
    }

    static void printRoute(Node head) {
        Node current = head;
        int count = 0;
        String first = head.data, last = "";

        while (current != null) {
            System.out.print(current.data + " -> ");
            last = current.data;
            count++;
            current = current.next;
        }

        System.out.println("null");
        System.out.println("Stops: " + count + ", First: "
                + first + ", Last: " + last);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] stops = new String[n];

        for (int i = 0; i < n; i++)
            stops[i] = sc.next();

        Node head = build(stops);
        printRoute(head);

        sc.close();
    }
}