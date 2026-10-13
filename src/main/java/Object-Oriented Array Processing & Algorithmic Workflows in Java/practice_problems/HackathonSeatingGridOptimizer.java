public class HackathonSeatingGridOptimizer {
    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0;
        }

        int sum = 0;

        for (int score : row) {
            sum += score;
        }

        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double average = rowAverage(seatingScores[i]);

            if (i > 0) {
                result.append(" | ");
            }

            result.append("Row ").append(i).append(": ");

            if (average < threshold) {
                result.append("Quiet Zone");
            } else {
                result.append("Buzzing Zone");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };

        System.out.println(classifyRows(seatingScores, 60));
    }
}