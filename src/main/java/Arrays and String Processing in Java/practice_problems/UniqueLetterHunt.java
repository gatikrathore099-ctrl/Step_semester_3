import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueLetterHunt {

    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        // Compute frequency of every character
        for (char ch : text.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Scan left to right to find first with frequency 1
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '\0'; // Return null char if none found
    }

    public static void runTest(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.printf("\"%s\" First Non-Repeating Character: '%c'\n", text, result);
        } else {
            System.out.printf("\"%s\" No Non-Repeating Character Found\n", text);
        }
    }

    public static void main(String[] args) {
        runTest("swiss");
        runTest("aabbcc");
    }
}