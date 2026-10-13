package main.java.WEEK4;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentPrefixSum = 0;

        // Map stores: <PrefixSum, Frequency>
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        // Base Case: A prefix sum of 0 has occurred 1 time (empty subarray)
        prefixSumMap.put(0, 1);

        for (int num : nums) {
            currentPrefixSum += num;

            // Check if there exists a previous prefix sum such that:
            // currentPrefixSum - previousPrefixSum = k  =>  previousPrefixSum = currentPrefixSum - k
            if (prefixSumMap.containsKey(currentPrefixSum - k)) {
                count += prefixSumMap.get(currentPrefixSum - k);
            }

            // Update frequency of current prefix sum
            prefixSumMap.put(currentPrefixSum, prefixSumMap.getOrDefault(currentPrefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));
    }
}