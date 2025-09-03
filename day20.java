import java.util.Stack;

public class day20 {

    // Function to insert element into the stack in sorted order
    private static void insertSorted(Stack<Integer> stack, int element) {
        // If stack is empty or top element is smaller, push the element
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        // Otherwise remove the top element and recurse
        int top = stack.pop();
        insertSorted(stack, element);

        // Put the top element back
        stack.push(top);
    }

    // Function to sort the stack recursively
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Remove the top element
            int top = stack.pop();

            // Sort the remaining stack
            sortStack(stack);

            // Insert the top element back in sorted order
            insertSorted(stack, top);
        }
    }

    // Driver code
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
