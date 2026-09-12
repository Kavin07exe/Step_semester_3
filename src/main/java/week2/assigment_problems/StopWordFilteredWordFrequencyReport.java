package week2.assigment_problems;

import java.util.*;

public class StopWordFilteredWordFrequencyReport {

    static void printFilteredWordFrequency(String feedback) {

        // Convert text to lowercase
        String cleanedText = feedback.toLowerCase();

        // Remove punctuation
        cleanedText = cleanedText.replace(".", "");
        cleanedText = cleanedText.replace(",", "");

        // Split into words
        String[] words = cleanedText.split("\\s+");

        // Stop words
        Set<String> stopWords = new HashSet<>();

        stopWords.add("the");
        stopWords.add("was");
        stopWords.add("and");
        stopWords.add("a");
        stopWords.add("is");
        stopWords.add("of");
        stopWords.add("in");

        // Store word frequencies
        HashMap<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {

            if (stopWords.contains(word)) {
                continue;
            }

            frequencyMap.put(
                    word,
                    frequencyMap.getOrDefault(word, 0) + 1
            );
        }

        // Convert map entries into a list
        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequencyMap.entrySet());

        // Sort by count in descending order
        entries.sort(
                (entry1, entry2) ->
                        entry2.getValue() - entry1.getValue()
        );

        // Print the result
        for (Map.Entry<String, Integer> entry : entries) {

            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        String feedback =
                "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}
