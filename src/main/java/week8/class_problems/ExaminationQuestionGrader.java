package week8.class_problems;

import java.util.Scanner;

abstract class Question {
    String type, correct, answer;
    double points;

    Question(String type, String correct, String answer, double points) {
        this.type = type;
        this.correct = correct;
        this.answer = answer;
        this.points = points;
    }

    abstract double grade();
}

class MCQ extends Question {
    MCQ(String c, String a, double p) {
        super("MCQ", c, a, p);
    }

    double grade() {
        return correct.equals(answer) ? points : 0;
    }
}

class TF extends Question {
    TF(String c, String a, double p) {
        super("TF", c, a, p);
    }

    double grade() {
        return correct.equals(answer) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String c, String a, double p) {
        super("ESSAY", c, a, p);
    }

    double grade() {
        int count = 0;
        for (String word : correct.split(",")) {
            if (answer.toLowerCase().contains(word.trim().toLowerCase())) {
                count++;
            }
        }
        return count >= 2 ? points * 0.75 : count == 1 ? points * 0.5 : 0;
    }
}

public class ExaminationQuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] s = line.split("\"");
            String type = s[0].trim().split(" ")[0];
            String correct = s[2].trim();
            String answer = s[4].trim();
            double points = Double.parseDouble(s[5].trim());

            Question q;
            if (type.equals("MCQ")) {
                q = new MCQ(correct, answer, points);
            } else if (type.equals("TF")) {
                q = new TF(correct, answer, points);
            } else {
                q = new Essay(correct, answer, points);
            }

            double score = q.grade();
            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}