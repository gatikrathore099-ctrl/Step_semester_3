public class IsbnNormalizerValidator {

    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        // Uppercase only the first 3 characters and keep the rest intact
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        // Stage 1: Length Validation
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        // Stage 2: Publisher Code Validation (first 3 characters)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Stage 3: Numeric Body Validation (remaining 10 characters)
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        // Stage 4: Formatting
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(pubCode).append("] ")
                 .append("YEAR: ").append(year).append(" | ")
                 .append("CATALOG: ").append(catalog);

        return formatted.toString();
    }

    public static void main(String[] args) {
        String code1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(code1));

        String code2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(code2));
    }
}
