import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) {
        Set<String> stopWords = new HashSet<>(Arrays.asList(
            "the", "was", "and", "a", "is", "of", "in"
        ));

        // 1. Normalize string: lowercased and strip punctuation
        String cleaned = feedback.toLowerCase()
                                 .replace(".", "")
                                 .replace(",", "")
                                 .replace("!", "")
                                 .replace("?", "");

        // 2. Split into words
        String[] words = cleaned.trim().split("\\s+");

        // 3. Count frequencies (skipping stop words)
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty() || stopWords.contains(word)) {
                continue;
            }
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // 4. Sort entries by frequency in descending order
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // 5. Print results
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
