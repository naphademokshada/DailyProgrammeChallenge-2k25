public class day9 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Take the first word as reference
        String prefix = strs[0];

        // Compare with each of the remaining words
        for (int i = 1; i < strs.length; i++) {
            // Reduce prefix until it matches the beginning of the current word
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    // Example usage
    public static void main(String[] args) {
        Day9 solution = new Day9();
        String[] strs = {"flower", "flow", "flight"};
        String result = solution.longestCommonPrefix(strs);
        System.out.println("Longest Common Prefix: \"" + result + "\"");
    }
}
