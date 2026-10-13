import java.util.Arrays;

public class DutyRoster {
    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        k = k % n; // Remove full turns
        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            rotated[newIndex] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        String[] result1 = rotateRoster(names, 2);
        String[] result2 = rotateRoster(names, 7);

        System.out.println("Sample 1 Output: " + Arrays.toString(result1)); // [D, E, A, B, C]
        System.out.println("Sample 2 Output: " + Arrays.toString(result2)); // [D, E, A, B, C]
    }
}