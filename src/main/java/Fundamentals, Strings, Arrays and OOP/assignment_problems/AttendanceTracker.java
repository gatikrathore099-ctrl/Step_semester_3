
public class AttendanceTracker {
    public static void attendanceSummary(int[] days) {
        int presentCount = 0;
        int maxStreak = 0;
        int currentStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        System.out.println("Present: " + presentCount + ", Longest streak: " + maxStreak);
    }

    public static void main(String[] args) {
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        int[] days2 = {0, 0, 0};

        System.out.print("Sample 1 Output: ");
        attendanceSummary(days1); // Present: 6, Longest streak: 3

        System.out.print("Sample 2 Output: ");
        attendanceSummary(days2); // Present: 0, Longest streak: 0
    }
}