package week12.assignment_problems;

import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
    }
}

public class LateComersInTheLine {

    static Node addFirst(Node head, String name) {
        Node newNode = new Node(name);
        newNode.next = head;
        return newNode;
    }

    static Node addLast(Node head, String name) {
        Node newNode = new Node(name);

        if (head == null)
            return newNode;

        Node current = head;

        while (current.next != null)
            current = current.next;

        current.next = newNode;
        return head;
    }

    static void printLine(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node head = null;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
            head = addLast(head, sc.next());

        int operations = sc.nextInt();

        for (int i = 0; i < operations; i++) {
            String op = sc.next();
            String name = sc.next();

            if (op.equals("addFirst"))
                head = addFirst(head, name);
            else if (op.equals("addLast"))
                head = addLast(head, name);
        }

        printLine(head);
        sc.close();
    }
}