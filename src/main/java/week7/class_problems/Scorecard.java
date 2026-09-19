package week7.class_problems;

public class Scorecard {

    private boolean[] answers;
    private int count;

    public Scorecard(int totalQuestions) {
        answers = new boolean[totalQuestions];
        count = 0;
    }

    public void recordAnswer(boolean correct) {
        if (count < answers.length) {
            answers[count] = correct;
            count++;
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < count; i++) {
            if (answers[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}