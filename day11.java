import java.util.*;

public class day11 {

    public List<String> permuteUnique(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;

        char[] chars = s.toCharArray();
        Arrays.sort(chars); // Sort to handle duplicates
        boolean[] used = new boolean[chars.length];
        backtrack(chars, used, new StringBuilder(), result);
        return result;
    }

    private void backtrack(char[] chars, boolean[] used, StringBuilder current, List<String> result) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // Skip used characters
            if (used[i]) continue;

            // Skip duplicates
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            // Choose
            used[i] = true;
            current.append(chars[i]);

            // Explore
            backtrack(chars, used, current, result);

            // Un-choose (backtrack)
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }

    // Example usage
    public static void main(String[] args) {
        Day11 solution = new Day11();
        String input = "abc";
        List<String> permutations = solution.permuteUnique(input);
        
        System.out.println("Unique permutations:");
        for (String perm : permutations) {
            System.out.println(perm);
        }
    }
}
