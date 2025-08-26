import java.util.Stack;

public class day12 {

    // Method to check if the given string is valid
    public boolean isValid(String s) {
        // Stack to store opening brackets
        Stack<Character> stack = new Stack<>();

        // Traverse each character in the string
        for (char c : s.toCharArray()) {
            // Push opening brackets to stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // For closing brackets
            else {
                // If stack is empty -> no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop(); // Get last opening bracket
                // Check if it matches with current closing bracket
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        // String is valid only if no unmatched brackets left
        return stack.isEmpty();
    }

    // Main method for quick testing
    public static void main(String[] args) {
        Day12 solution = new Day12();
        String s = "[{()}]";
        System.out.println(solution.isValid(s));  // Output: true
    }
}
