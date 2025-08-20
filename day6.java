import java.util.*;

public class day6 {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;

        // Initialize with sum 0 at index -1 to handle subarrays starting from index 0
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If the same sum has been seen before
            if (sumMap.containsKey(sum)) {
                for (Integer startIdx : sumMap.get(sum)) {
                    result.add(new int[]{startIdx + 1, i});
                }
            }

            // Add current index to the list of indices for this sum
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        if (subarrays.isEmpty()) {
            System.out.println("No subarrays found with sum zero.");
        } else {
            System.out.print("Subarrays with zero sum: ");
            for (int[] subarray : subarrays) {
                System.out.print("(" + subarray[0] + ", " + subarray[1] + ") ");
            }
        }
    }
}
