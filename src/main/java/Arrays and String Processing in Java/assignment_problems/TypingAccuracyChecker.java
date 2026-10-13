public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int totalChars = original.length();
        int matched = 0;
        int firstMismatchPos = -1;
        char originalChar = ' ';
        char typedChar = ' ';

        for (int i = 0; i < totalChars; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                // Record the first mismatch position (1-based index)
                firstMismatchPos = i + 1;
                originalChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        double accuracy = ((double) matched / totalChars) * 100;

        StringBuilder output = new StringBuilder();
        output.append(String.format("Matched: %d/%d | Accuracy: %.2f%% | ", matched, totalChars, accuracy));

        if (firstMismatchPos == -1) {
            output.append("No Mismatches");
        } else {
            output.append(String.format("First Mismatch at position %d ('%c' vs '%c')", 
                    firstMismatchPos, originalChar, typedChar));
        }

        System.out.println(output.toString());
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
