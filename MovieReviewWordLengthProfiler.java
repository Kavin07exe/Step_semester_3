package string.assignment_problems;

public class MovieReviewWordLengthProfiler {

    static void analyzeReview(String review) {

        String[] words = review.split(" ");

        int totalLength = 0;
        int longestLength = 0;
        String longestWord = "";

        for (String word : words) {

            int length = word.length();

            System.out.println(word + " -> " + length);

            totalLength += length;

            if (length > longestLength) {
                longestLength = length;
                longestWord = word;
            }
        }

        double averageLength = (double) totalLength / words.length;

        System.out.println("Total Words: " + words.length);
        System.out.println("Average Word Length: " + averageLength);
        System.out.println("Longest Word: " + longestWord);
    }

    public static void main(String[] args) {

        String review = "Amazing visuals but the story was predictable";

        analyzeReview(review);
    }
}
