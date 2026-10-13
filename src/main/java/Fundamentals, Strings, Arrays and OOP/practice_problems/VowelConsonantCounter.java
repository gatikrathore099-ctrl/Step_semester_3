public class VowelConsonantCounter {
    public static void countVowelsAndConsonants(String word) {
        int vowels = 0;
        int consonants = 0;
        String lower = word.toLowerCase();

        for (int i = 0; i < lower.length(); i++) {
            char ch = lower.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void main(String[] args) {
        countVowelsAndConsonants("Programming");
    }
}