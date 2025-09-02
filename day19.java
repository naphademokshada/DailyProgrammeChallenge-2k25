import java.util.*;

public class day19 {
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            // If token is a number, push it to the stack
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                // Operator: Pop top two values
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b); // Integer division
                        break;
                }
            }
        }
        return stack.pop();
    }

    // Utility to check if token is a number (handles negatives too)
    private static boolean isNumber(String s) {
        if (s.length() > 1 && (s.charAt(0) == '-' || s.charAt(0) == '+')) {
            return s.substring(1).chars().allMatch(Character::isDigit);
        }
        return s.chars().allMatch(Character::isDigit);
    }

    public static void main(String[] args) {
        String expression = "2 1 + 3 *";
        int result = evaluatePostfix(expression);
        System.out.println(result); // Output: 9
    }
}


