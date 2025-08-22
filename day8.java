public class day8 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";

        // Step 1: Trim the string and split by spaces
        String[] words = s.trim().split("\\s+");

        // Step 2: Reverse the array of words
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }

    // Example usage
    public static void main(String[] args) {
        Day8 solution = new Day8();
        String input = "  the   sky   is  blue  ";
        String output = solution.reverseWords(input);
        System.out.println("Reversed: \"" + output + "\"");
    }
}
