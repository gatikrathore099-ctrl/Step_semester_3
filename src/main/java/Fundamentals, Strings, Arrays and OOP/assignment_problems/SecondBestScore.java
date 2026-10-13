public class SecondBestScore {
    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score > second && score < highest) {
                second = score;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int[] scores1 = {45, 78, 92, 78, 60};
        int[] scores2 = {50, 50, 50};

        System.out.println("Sample 1 Output: " + secondHighest(scores1)); // 78
        System.out.println("Sample 2 Output: " + secondHighest(scores2)); // -1
    }
}