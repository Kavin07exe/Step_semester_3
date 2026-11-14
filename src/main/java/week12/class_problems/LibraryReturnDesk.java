package week12.class_problems;

import java.util.Scanner;

public class LibraryReturnDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] stack = new String[3];
        String[] queue = new String[3];

        int top = -1, front = 0, rear = 0, size = 0;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String cmd = sc.next();

            switch (cmd) {
                case "RETURN":
                    String book = sc.next();
                    if (top == 2)
                        System.out.println(book + " rejected: pile is full");
                    else {
                        stack[++top] = book;
                        System.out.println(book + " placed on pile");
                    }
                    break;

                case "SHELVE":
                    if (top == -1)
                        System.out.println("pile is empty");
                    else
                        System.out.println("shelved " + stack[top--]);
                    break;

                case "WAIT":
                    String name = sc.next();
                    if (size == 3)
                        System.out.println(name + " rejected: line is full");
                    else {
                        queue[rear] = name;
                        rear = (rear + 1) % 3;
                        size++;
                        System.out.println(name + " joined the line");
                    }
                    break;

                case "SERVE":
                    if (size == 0)
                        System.out.println("no one waiting");
                    else {
                        System.out.println("served " + queue[front]);
                        front = (front + 1) % 3;
                        size--;
                    }
                    break;
            }
        }

        sc.close();
    }
}