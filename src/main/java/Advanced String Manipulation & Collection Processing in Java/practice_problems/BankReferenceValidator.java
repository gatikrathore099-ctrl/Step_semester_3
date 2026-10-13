public class BankReferenceValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return bankCode + rest;
    }

    public static String validateAndFormat(String reference) {
        String normalized = normalizeReference(reference);

        if (normalized.length() != 14) {
            return "Invalid: wrong length (must be 14 characters)";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Validate remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Extract components for formatting
        String bankCode = normalized.substring(0, 3);
        String day = normalized.substring(3, 5);
        String month = normalized.substring(5, 7);
        String year = normalized.substring(7, 9);
        String seq = normalized.substring(9, 14);

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(bankCode).append("] DATE: ")
                 .append(day).append("/").append(month).append("/").append(year)
                 .append(" | SEQ: ").append(seq);

        return formatted.toString();
    }

    public static void main(String[] args) {
        String input1 = " hdf03022600042 ";
        String input2 = "12F03022600042";

        System.out.println("\"" + input1 + "\" -> " + validateAndFormat(input1));
        System.out.println("\"" + input2 + "\" -> " + validateAndFormat(input2));
    }
}