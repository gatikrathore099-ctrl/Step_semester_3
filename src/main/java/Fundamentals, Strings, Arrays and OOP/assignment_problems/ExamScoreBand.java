
public class ExamScoreBand {
    public static int countInBand(int[] scores, int low, int high) {
        int leftIndex = lowerBound(scores, low);
        int rightIndex = upperBound(scores, high);
        return rightIndex - leftIndex;
    }

    // Finds the first index where score >= target
    private static int lowerBound(int[] scores, int target) {
        int low = 0, high = scores.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Finds the first index where score > target
    private static int upperBound(int[] scores, int target) {
        int low = 0, high = scores.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println("Sample 1 Output: " + countInBand(scores, 42, 58)); // 6
        System.out.println("Sample 2 Output: " + countInBand(scores, 90, 100)); // 0
    }
}