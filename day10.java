import java.util.*;

public class day10 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        // Map to store sorted string as key and list of anagrams as value
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Convert string to char array, sort it, and use it as the key
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);

            // Add original string to the correct group in the map
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }

        // Return the values of the map as the final result
        return new ArrayList<>(map.values());
    }

    // Example usage
    public static void main(String[] args) {
        Day10 solution = new Day10();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupedAnagrams = solution.groupAnagrams(strs);

        // Printing the result
        for (List<String> group : groupedAnagrams) {
            System.out.println(group);
        }
    }
}
